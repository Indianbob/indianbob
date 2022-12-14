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

        String Path = "D:\\INDIANBOB\\Indian_Bob\\indianbob\\src\\main\\resources\\static\\images\\patient";
        String fileUploadDirectory = "/images/patient/";
        System.out.println("aaa" + fileUploadDirectory);
        String fileName = thumbnailImg1.getName();
        System.out.println(fileName);
        System.out.println(fileUploadDirectory);

        //Requestparam?????? ?????? file??? ?????? ?????? ?????? ?????? ??????.
        MultipartFile paramFile = thumbnailImg1;
        try { //????????? ?????? ?????? ???????
            // ????????? ????????? ????????? ??????
            Map<String, String> fileMap = null;
            if (paramFile.getSize() > 0) { // ???????????? ????????????(getSize??? 0?????? ??????)
                String originFileName = paramFile.getOriginalFilename(); // ?????? ????????? ??????

                // ?????? ????????? ??????
                String ext = originFileName.substring(originFileName.lastIndexOf("."));

                //UUID? : 16????????? ????????? ????????? ??????????????? ?????? / toString?????? ???????????? ?????????/ ??? ????????? "-"??? ????????? ?????? ??????
                // ????????? ????????? + ????????? ??????(????????? ???????????? ????????? UUID.randomUUID() ??????
                //ext : ????????? ????????? ???????????? ??????
                String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                // ????????? ????????? ????????? ??????????????? ????????? ??????
                paramFile.transferTo(new File(Path + "/" + savedFileName));


                String PatientImagePath = (fileUploadDirectory + savedFileName);
                // ???????????? ?????? DB??? ?????? ??????
                fileMap = new HashMap<>();
                fileMap.put("originFileName", originFileName); // ?????? ?????? ??????
                fileMap.put("savedFileName", savedFileName); //  ?????? ?????? ??????
                fileMap.put("uploadDirectory", PatientImagePath); // ?????? ?????? ????????????


                String fieldName = paramFile.getName(); // ?????? ????????? ??????
            }

            // ???????????? ?????? ????????? ?????? ????????? ???????????? ?????? DTO??? ?????? ??????


            patient.setOriginFileName(fileMap.get("originFileName"));
            patient.setSavedFileName(fileMap.get("savedFileName"));
            patient.setPatientPicture(fileMap.get("uploadDirectory"));

            System.out.println(" ?????? ?????? ?????? : " + patient.getOriginFileName());
            System.out.println(" ????????? ?????? ?????? : " + patient.getSavedFileName());
            System.out.println(" ????????? ?????? ?????? : " + patient.getPatientPicture());
            System.out.println(" ???????????? ?????? : " + patient);

            patientService.insertPatient(patient);

            System.out.println("?????? ?????? ??????");

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            }

        System.out.println("===========");
        mv.setViewName("redirect:/patient");
        return mv;
    }
}
