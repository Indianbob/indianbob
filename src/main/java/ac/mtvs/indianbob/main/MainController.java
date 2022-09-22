package ac.mtvs.indianbob.main;

import ac.mtvs.indianbob.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public ModelAndView mainPage(ModelAndView mv) {

        mv.setViewName("/main/main");

        return mv;
    }

    @GetMapping("/detection")
    public ModelAndView detectionPage(ModelAndView mv) {

        mv.setViewName("/detection/list");

        return mv;
    }

    @GetMapping("/patient")
    public ModelAndView patientPage(ModelAndView mv) {

        List<PatientDTO> patientList = new ArrayList<>();

        patientList.add(new PatientDTO(1, "오바마", "2000.09.15 / 22세", "당뇨", "남" ));
        patientList.add(new PatientDTO(2, "링컨", "1999.07.22 / 23세", "고혈압","남" ));
        patientList.add(new PatientDTO(3, "부시", "1998.02.03 / 24세", "치매" ,"남"));
        patientList.add(new PatientDTO(4, "워싱턴", "2000.12.06 / 21세", "골다공증", "남" ));

        mv.addObject("patientList", patientList);

        mv.setViewName("pages/patient/patient");
        return mv;
    }

    @GetMapping("/patient/detail/1")
    public ModelAndView patientDetail(ModelAndView mv){

        PatientDTO patient = new PatientDTO(1, "오바마", "2000.09.15 / 22세", "당뇨", "남");

        String script = "당뇨 환자로, 매일 [17:30] 에 약을 복용해야 함.";

        mv.addObject("patient",patient);
        mv.addObject("script",script);

        mv.setViewName("pages/patient/patientdetail");

        return mv;
    }

    @GetMapping("/patient/insert")
    public ModelAndView patientInsert(ModelAndView mv){

        mv.setViewName("/pages/patient/patientinsert");


        return mv;
    }

}
