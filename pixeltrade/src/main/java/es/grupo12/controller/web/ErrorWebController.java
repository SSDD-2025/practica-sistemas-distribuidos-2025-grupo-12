package es.grupo12.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ErrorWebController {

    @RequestMapping("/error")
    public String invalidUrl(Model model) {
        return "errorPage";
    }
    
}
