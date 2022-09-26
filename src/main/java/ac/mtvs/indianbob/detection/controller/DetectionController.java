package ac.mtvs.indianbob.detection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/detection")
public class DetectionController {

    @GetMapping("/detail")
    public ModelAndView detectionDetailPage(ModelAndView mv, @RequestParam(name="patientCode") int patientCode) {

        System.out.println(patientCode);

        // 회원 코드로 회원 정보 조회
        // 회원 코드로 최근 탐지 정보 조회
        // mv에 회원 정보 및 탐지 정보 추가 후 타임리프에서 사용

        mv.setViewName("detection/detail");

        return mv;
    }
}
