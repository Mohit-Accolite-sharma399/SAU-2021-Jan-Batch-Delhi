package com.au2021;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IOException.class)
    public ModelAndView handleLargeResultException(HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", "The result is greater than 1000");
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("LargeNumber");
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleNANException(HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", "Please Enter Integers!!!");
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("GenricException");
        return modelAndView;
    }
}
