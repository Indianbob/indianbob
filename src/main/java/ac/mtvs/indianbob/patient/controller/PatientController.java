package ac.mtvs.indianbob.patient.controller;

import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientApiDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/patient")
@RestController
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

    @PostMapping("/info")
    public Object patientPage(HttpServletRequest request) {

        List<PatientApiDTO> patientApiList = patientService.selectAllPatientApi();

        System.out.println(request);

        return patientApiList;
    }

    @GetMapping("/detail")
    public ModelAndView patientDetail(@RequestParam String code, ModelAndView mv){

        List<PatientDTO> patientList = patientService.selectAllPatient();

        mv.addObject("patientList", patientList);
        mv.addObject("code",code);

        mv.setViewName("pages/patient/patientdetail");

        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView patientInsert(ModelAndView mv){

        mv.setViewName("/pages/patient/patientinsert");

        return mv;
    }
}
