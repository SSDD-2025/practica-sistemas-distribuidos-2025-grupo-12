package es.grupo12.controller.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorWebController implements ErrorController {

    @RequestMapping("/error")
    public String invalidUrl(Model model) {
        return "errorPage";
    }
    
}
