package ac.mtvs.indianbob.patient.controller;

import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

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

    @GetMapping("/detail/1")
    public ModelAndView patientDetail(ModelAndView mv){

//        PatientDTO patient = new PatientDTO(1, "오바마", "2000.09.15 / 22세", "당뇨", "남");

        String script = "당뇨 환자로, 매일 [17:30] 에 약을 복용해야 함.";

//        mv.addObject("patient",patient);
        mv.addObject("script",script);

        mv.setViewName("pages/patient/patientdetail");

        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView patientInsert(ModelAndView mv){

        mv.setViewName("/pages/patient/patientinsert");


        return mv;
    }
}
