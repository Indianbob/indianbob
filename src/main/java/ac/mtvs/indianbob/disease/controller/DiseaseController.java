package ac.mtvs.indianbob.disease.controller;

import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import ac.mtvs.indianbob.disease.service.DiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/disease")
public class DiseaseController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }
    @GetMapping("/list")
    public ModelAndView diseaseList(ModelAndView mv) {
        log.info("");
        log.info("");
        log.info("[DiseaseController] =========================================================");

        List<DiseaseDTO> diseaseList = diseaseService.selectAllDiseaseList();
        log.info("[DiseaseController] diseaseList : " + diseaseList);

        mv.addObject("diseaseList", diseaseList);

        mv.setViewName("pages/disease/diseaseList");

        log.info("[DiseaseController] =========================================================");

        return mv;
    }

    @GetMapping("/regist")
    public String goRegister() {return "pages/disease/diseaseRegist";}
}



