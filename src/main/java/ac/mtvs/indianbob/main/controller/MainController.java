package ac.mtvs.indianbob.main.controller;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.dto.DetectionPatientDTO;
import ac.mtvs.indianbob.detection.model.service.DetectionService;
import ac.mtvs.indianbob.model.PatientApi.patientApi;
import ac.mtvs.indianbob.paging.Pagenation;
import ac.mtvs.indianbob.paging.SelectCriteria;
import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {

    private PatientService patientService;
    private DetectionService detectionService;

    @Autowired
    public MainController(PatientService patientService, DetectionService detectionService) {
        this.patientService = patientService;
        this.detectionService = detectionService;
    }

    @GetMapping("/")
    public ModelAndView loginPage(ModelAndView mv) {

        mv.setViewName("pages/member/login");

        return mv;
    }

    @GetMapping("/main")
    public ModelAndView mainPage(ModelAndView mv) {

        mv.setViewName("main/main");

        return mv;
    }

    @GetMapping("/getpatientapi")
    public Object patientApi(){
        patientApi patientApi = new patientApi();
        patientApi.patientCode="코드";


        return patientApi;
    }

    @GetMapping("/detection")
    public ModelAndView detectionPage(HttpServletRequest request, ModelAndView mv) throws IOException {

        List<DetectionPatientDTO> detectionPatientList = detectionService.selectAllDetectionPatient();

        System.out.println(detectionPatientList);


        // 페이지 네이션
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        SelectCriteria selectCriteria = null;
        int totalCount = detectionPatientList.size();
        int limit = 10;
        int buttonAmount = 5;
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

//        List<DetectionPatientDTO> detectionPatientPagenation = detectionService.selectPagenationDetectionPatient(selectCriteria);

//        System.out.println(detectionPatientPagenation);
        mv.addObject("detectionPatientList", detectionPatientList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/detection/list");


        return mv;
    }
}
