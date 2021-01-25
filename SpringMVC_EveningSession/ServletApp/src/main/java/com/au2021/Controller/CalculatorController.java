package com.au2021.Controller;

import com.au2021.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService service ;


    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String input1, @RequestParam String input2,
                                     @RequestParam String operation, ModelMap model) throws Exception{

        boolean isValidNumber = service.validateInput(input1 ,  input2) ;
        if(!isValidNumber){
            throw new IllegalArgumentException() ;
        }

        int integer1 = Integer.parseInt(input1) ;
        int integer2 = Integer.parseInt(input2) ;

        int result ;

        switch(operation){
            case "add" :result = integer1 + integer2 ;
                        if(result > 1000){
                             throw new IOException() ;
                        }
                        break ;
            case "sub" :result = integer1 - integer2 ;
                        if(result > 1000){
                            throw new IOException() ;
                        }
                        break ;
            case "mul" :result = integer1 * integer2 ;
                        if(result > 1000){
                            throw new IOException() ;
                        }
                        break ;
            case "div" :if(integer2 == 0){
                            throw new ArithmeticException() ;
                        }
                        result = integer1 / integer2 ;
                        if(result > 1000){
                            throw new IOException() ;
                        }
                        break ;
            default:result = 0 ;
        }

        model.put("result", result);

        return "Result";
    }



    @RequestMapping(value = "/Result", method = RequestMethod.GET)
    public String getResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "Result";
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleDivideByZeroException(HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        String error = " { Operation : '/' , message : 'Divide by Zero'} " ;
        modelAndView.addObject("exception", error);
        modelAndView.addObject("url", request.getRequestURL());


        modelAndView.setViewName("divideByZero");
        return modelAndView;
    }


}
