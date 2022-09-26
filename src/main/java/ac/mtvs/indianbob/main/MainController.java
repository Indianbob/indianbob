package ac.mtvs.indianbob.main;

import ac.mtvs.indianbob.model.PatientApi.patientApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
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
    public ModelAndView detectionPage(ModelAndView mv) {

        mv.setViewName("/detection/list");

        return mv;
    }

}
