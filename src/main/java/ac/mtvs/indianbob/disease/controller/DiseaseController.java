package ac.mtvs.indianbob.disease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disease")
public class DiseaseController {
    @GetMapping("/list")
    public String showList() {
        return "pages/disease/diseaseList";
    }
}



