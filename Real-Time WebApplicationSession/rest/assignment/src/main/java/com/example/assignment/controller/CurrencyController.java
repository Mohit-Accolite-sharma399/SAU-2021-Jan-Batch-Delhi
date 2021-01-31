package com.example.assignment.controller;

import com.example.assignment.dao.Currency;
import com.example.assignment.dao.User;
import com.example.assignment.service.CurrencyService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> login(@RequestBody User user){
        return new ResponseEntity<>(this.currencyService.login(user),HttpStatus.OK);
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> register(@RequestBody User user){
        return new ResponseEntity<>(this.currencyService.register(user),HttpStatus.OK);
    }



    @GetMapping("/user/fake")
    @CrossOrigin("*")
    public List<Currency> getfake(){
        return this.currencyService.getFake();
    }


    @GetMapping("/user")
    @CrossOrigin("*")
    public List<User> get(){
        return this.currencyService.get();
    }

    @GetMapping("/user/{email}")
    @CrossOrigin("*")
    public List<Currency> getDetails(@PathVariable String email){
        System.out.println(email);
        return this.currencyService.getByEmail(email);
    }

    @GetMapping("/user/daily")
    @CrossOrigin("*")
    public List<Currency> getdaily(){
        return this.currencyService.getdaily();
    }


    @PostMapping("/user")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> insert(@RequestBody Currency currency){
        return new ResponseEntity<>(this.currencyService.insert(currency), HttpStatus.OK);
    }


}
