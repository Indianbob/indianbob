package ac.mtvs.indianbob.patient.controller;

import ac.mtvs.indianbob.patient.PatientService.PatientService;
import ac.mtvs.indianbob.patient.model.dto.PatientApiDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
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

    @GetMapping("/info")
    public Object patientPage() {

        List<PatientApiDTO> patientApiList = patientService.selectAllPatientApi();

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
    public ModelAndView goInserter(ModelAndView mv) {

        mv.setViewName("pages/patient/patientinsert");

        return mv;
    }

    @PostMapping("/insert")
    public String insertPatient(@ModelAttribute PatientDTO patient, RedirectAttributes rttr){

        System.out.println("PatientController PatientInsert ==============");
        System.out.println(patient);

        patientService.insertPatient(patient);

        rttr.addFlashAttribute("message","환자 등록에 성공하셨습니다.");

        System.out.println("===========");


        return "redirect:/patient";
    }
}
