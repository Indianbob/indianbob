package ac.mtvs.indianbob.main;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.dto.DetectionPatientDTO;
import ac.mtvs.indianbob.detection.model.service.DetectionService;
import ac.mtvs.indianbob.model.PatientApi.patientApi;
import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/getpatientapi")
    public Object patientApi(){
        patientApi patientApi = new patientApi();
        patientApi.patientCode="코드";


        return patientApi;
    }

    @GetMapping("/detection")
    public ModelAndView detectionPage(ModelAndView mv) {

        List<DetectionPatientDTO> detectionPatientList = detectionService.selectAllDetectionPatient();

        System.out.println(detectionPatientList);

        mv.addObject("detectionPatientList", detectionPatientList);
        mv.setViewName("/detection/list");

        return mv;
    }
}
