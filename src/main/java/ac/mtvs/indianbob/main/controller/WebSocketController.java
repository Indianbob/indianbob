package ac.mtvs.indianbob.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class WebSocketController {

    @GetMapping("/test1")
    public ModelAndView mainWebSocketPage(ModelAndView mv) {

        mv.setViewName("main/test");

        return mv;
    }
}
