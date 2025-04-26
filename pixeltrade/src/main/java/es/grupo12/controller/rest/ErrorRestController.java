package es.grupo12.controller.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ErrorRestController {

    @RequestMapping("/error")
    public String invalidUrl(Model model) {
        return "errorPage";
    }
    
}
