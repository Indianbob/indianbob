package ac.mtvs.indianbob.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
