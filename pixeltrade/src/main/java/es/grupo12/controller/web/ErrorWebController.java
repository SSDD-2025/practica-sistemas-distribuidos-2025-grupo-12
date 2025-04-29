package es.grupo12.controller.web;

import java.time.LocalDateTime;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import es.grupo12.model.CustomErrorJson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorWebController implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error", produces = MediaType.TEXT_HTML_VALUE)
    public String handleHtmlError(Model model) {
        return "errorPage"; 
    }
    
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomErrorJson handleErrorJson(HttpServletRequest request, WebRequest webRequest) {
        Map<String, Object> mapErrors = buildMapErrors(webRequest);
        int status = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        return new CustomErrorJson(LocalDateTime.now(),status,
                (String) mapErrors.get("error"),
                (String) mapErrors.get("trace"),
                (String) mapErrors.get("message"),
                (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
    }

    
    private Map<String, Object> buildMapErrors(WebRequest webRequest) {
            ErrorAttributeOptions options = ErrorAttributeOptions.of(
                    ErrorAttributeOptions.Include.STACK_TRACE,
                    ErrorAttributeOptions.Include.ERROR,
                    ErrorAttributeOptions.Include.MESSAGE);
            return errorAttributes.getErrorAttributes(webRequest, options);
    }

}
