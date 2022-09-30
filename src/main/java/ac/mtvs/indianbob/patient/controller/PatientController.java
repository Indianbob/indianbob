package ac.mtvs.indianbob.patient.controller;

import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientApiDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/patient")
@RestController
public class PatientController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("")
    public ModelAndView patientPage(ModelAndView mv) {

        List<PatientDTO> patientList = patientService.selectAllPatient();

        mv.addObject("patientList", patientList);

        System.out.println("aaa");

        mv.setViewName("pages/patient/patient");
        return mv;
    }

    @GetMapping("/info")
    public Object patientPage() {

        List<PatientApiDTO> patientApiList = patientService.selectAllPatientApi();

        return patientApiList;
    }

    @GetMapping("/detail")
    public ModelAndView patientDetail(@RequestParam int code, ModelAndView mv){


        PatientDTO patient = patientService.selectPatientByPatientCode(code);

        mv.addObject("patient",patient);

        mv.setViewName("pages/patient/patientdetail");

        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView goInserter(ModelAndView mv) {

        mv.setViewName("pages/patient/patientinsert");

        return mv;
    }

    @PostMapping("/insert")
    public ModelAndView insertPatient(@ModelAttribute PatientDTO patient, RedirectAttributes rttr,
                                  @RequestParam("thumbnailImg1")MultipartFile thumbnailImg1,
                                HttpServletRequest request, ModelAndView mv){

        System.out.println("PatientController PatientInsert ==============");
        System.out.println(patient);
        System.out.println(thumbnailImg1);
        String realpath = request.getContextPath();
        String rootLocation = IMAGE_DIR;

        String Path = "D:\\indianbob\\indianbob\\src\\main\\resources\\static\\images\\patient";
        String fileUploadDirectory = "/images/patient/";
        System.out.println("aaa" + fileUploadDirectory);
        String fileName = thumbnailImg1.getName();
        System.out.println(fileName);
        System.out.println(fileUploadDirectory);

        //Requestparam으로 받은 file을 객체 안에 저장 하는 역할.
        MultipartFile paramFile = thumbnailImg1;
        try { //파일이 없을 수도 있음?
            // 각각의 파일에 대하여 수행
            Map<String, String> fileMap = null;
            if (paramFile.getSize() > 0) { // 정상적인 파일이면(getSize가 0보다 크면)
                String originFileName = paramFile.getOriginalFilename(); // 원래 파일명 저장

                // 파일 확장자 저장
                String ext = originFileName.substring(originFileName.lastIndexOf("."));

                //UUID? : 16진수의 랜덤한 수열을 반환해주는 객체 / toString으로 텍스트로 바꾸고/ 그 사이에 "-"가 있는데 그걸 제거
                // 저장할 파일명 + 확장자 저장(오류가 발생하지 않도록 UUID.randomUUID() 사용
                //ext : 위에서 정의한 확장자를 의미
                String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                // 설정한 경로와 변경한 파일명으로 업로드 처리
                paramFile.transferTo(new File(Path + "/" + savedFileName));


                String PatientImagePath = (fileUploadDirectory + savedFileName);
                // 업로드한 파일 DB에 정보 저장
                fileMap = new HashMap<>();
                fileMap.put("originFileName", originFileName); // 파일 원본 이름
                fileMap.put("savedFileName", savedFileName); //  파일 저장 이름
                fileMap.put("uploadDirectory", PatientImagePath); // 파일 저장 디렉토리


                String fieldName = paramFile.getName(); // 파일 필드명 추출
            }

            // 비지니스 로직 호출에 맞는 폼으로 설정하기 위해 DTO에 정보 담기


            patient.setOriginFileName(fileMap.get("originFileName"));
            patient.setSavedFileName(fileMap.get("savedFileName"));
            patient.setPatientPicture(fileMap.get("uploadDirectory"));

            System.out.println(" 원래 파일 이름 : " + patient.getOriginFileName());
            System.out.println(" 저장한 파일 이름 : " + patient.getSavedFileName());
            System.out.println(" 저장한 파일 경로 : " + patient.getPatientPicture());
            System.out.println(" 전달하는 객체 : " + patient);

            patientService.insertPatient(patient);

            System.out.println("사진 등록 성공");

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            }

        System.out.println("===========");
        mv.setViewName("redirect:/patient");
        return mv;
    }
}
