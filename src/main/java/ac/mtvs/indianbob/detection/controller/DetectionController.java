package ac.mtvs.indianbob.detection.controller;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.service.DetectionService;
import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/detection")
public class DetectionController {

    private PatientService patientService;
    private DetectionService detectionService;

    @Autowired
    public DetectionController(PatientService patientService, DetectionService detectionService) {
      this.patientService = patientService;
      this.detectionService = detectionService;
    }

    @GetMapping("/detail")
    public ModelAndView detectionDetailPage(ModelAndView mv, @RequestParam("patientCode") int patientCode) {

        System.out.println(patientCode);

        // 회원 코드로 회원 정보 조회
        PatientDTO patient = patientService.selectPatientByPatientCode(patientCode);
        DetectionDTO recentDetection = detectionService.selectRecentDetectionByPatientCode(patientCode);
        System.out.println("recent" + recentDetection);
        // 회원 코드로 최근 탐지 정보 조회
        // mv에 회원 정보 및 탐지 정보 추가 후 타임리프에서 사용

        mv.addObject("patient", patient);
        mv.addObject("recentDetection", recentDetection);
        mv.setViewName("detection/detail");

        return mv;
    }
}
