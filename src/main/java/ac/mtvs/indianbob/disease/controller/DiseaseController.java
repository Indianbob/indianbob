package ac.mtvs.indianbob.disease.controller;

import ac.mtvs.indianbob.common.exception.disease.DiseaseModifyException;
import ac.mtvs.indianbob.common.exception.disease.DiseaseRegistException;
import ac.mtvs.indianbob.common.exception.disease.DiseaseRemoveException;
import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import ac.mtvs.indianbob.disease.service.DiseaseService;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/disease")
public class DiseaseController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final DiseaseService diseaseService;

    @Autowired
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

    @PostMapping("/regist")
    public String registDisease(@ModelAttribute DiseaseDTO disease, RedirectAttributes rttr) throws DiseaseRegistException {

        log.info("");
        log.info("");
        log.info("[DiseaseController] diseaseBoard =========================================================");
        log.info("[DiseaseController] diseaseBoard Request : " + disease);

        diseaseService.registDisease(disease);

        rttr.addFlashAttribute("message", "질병 등록에 성공하셨습니다!");

        log.info("[DiseaseController] diseaseBoard =========================================================");

        return "redirect:/disease/list";
    }

    @GetMapping("/detail")
    public String selectDiseaseDetail(HttpServletRequest request, Model model) {

        log.info("");
        log.info("");
        log.info("[DiseaseController] selectDiseaseDetail =========================================================");

        Long no = Long.valueOf(request.getParameter("no"));
        log.info("[DiseaseController] selectDiseaseDetail No : " + no);

        DiseaseDTO diseaseDetail = diseaseService.selectDiseaseDetail(no);
        log.info("[DiseaseController] diseaseDetail : " + diseaseDetail);
        model.addAttribute("disease", diseaseDetail);

        log.info("[DiseaseController] selectDiseaseDetail =========================================================");

        return "pages/disease/diseaseDetail";
    }

    @GetMapping("/update")
    public String goModifyNotice(HttpServletRequest request, Model model) {

        log.info("");
        log.info("");
        log.info("[DiseaseController] modifyDisease =========================================================");

        Long no = Long.valueOf(request.getParameter("no"));

        DiseaseDTO disease = diseaseService.selectDiseaseDetail(no);

        model.addAttribute("disease", disease);

        log.info("[DiseaseController] modifyDisease =========================================================");

        return "pages/disease/diseaseUpdate";
    }

    @PostMapping("/update")
    public String modifyDisease(@ModelAttribute DiseaseDTO disease, RedirectAttributes rttr) throws DiseaseModifyException {

        log.info("");
        log.info("");
        log.info("[DiseaseController] modifyNotice =========================================================");

        log.info("[DiseaseController] disease : "+ disease);
        diseaseService.modifyDisease(disease);


        rttr.addFlashAttribute("message", "공지사항 수정에 성공하셨습니다!");

        log.info("[DiseaseController] modifyDisease =========================================================");
        return "redirect:/disease/list";
    }

    @GetMapping("/delete")
    public String removeDisease(HttpServletRequest request, RedirectAttributes rttr) throws DiseaseRemoveException {

        Long no = Long.valueOf(request.getParameter("no"));

        diseaseService.removeDisease(no);

        rttr.addFlashAttribute("message", "공지사항 삭제에 성공하셨습니다!");

        return "redirect:/disease/list";
    }

}



