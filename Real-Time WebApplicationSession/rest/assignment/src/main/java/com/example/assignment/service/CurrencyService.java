package com.example.assignment.service;

import com.example.assignment.dao.Currency;
import com.example.assignment.dao.User;
import com.example.assignment.repo.CurrencyRepo;
import com.example.assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private UserRepo userRepo;


    public String login(User user) {
        String password=user.getPassword();
        String passwordOrg=this.userRepo.checkLogin(user.getEmail());
        if(passwordOrg.equals(password)){
            return "Matched";
        }
        else{
            return "Not Matched";
        }

    }

    public Boolean register(User user){

        try{
            System.out.println(user);
            this.userRepo.save(user);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return  false;
        }
    }

    public List<Currency> getFake(){
        return this.currencyRepo.fakeuser();
    }

    public Boolean insert(Currency currency) {
        System.out.println(currency);

        String id=currency.getCurrency_id();
        int res=this.currencyRepo.usercheck(id);
        System.out.println(res);
        try {
            if (res > 0) {
                currency.setIsfake(true);
                this.currencyRepo.save(currency);

            } else {
                this.currencyRepo.save(currency);
            }
            return true;
        }
        catch(Exception e){
            return false;
        }

    }


    public List<Currency> getdaily() {
        return this.currencyRepo.dailyresult(LocalDate.now());
    }



    public List<User> get() {
        return this.userRepo.findAll();
    }

    public List<Currency> getByEmail(String email) {
        return this.currencyRepo.findByEmail(email);
    }


}
