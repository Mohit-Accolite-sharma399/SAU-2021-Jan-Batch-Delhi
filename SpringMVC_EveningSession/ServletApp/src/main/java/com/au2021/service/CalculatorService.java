package com.au2021.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public boolean validateInput(String input1, String input2 ) {

		boolean isNumber = true ;

		for(int i = 0 ; i < input1.length() ; i++){
			if(!(input1.charAt(i) >= '0' && input1.charAt(i) <= '9')){
				isNumber = false ;
			}
		}

		for(int i = 0 ; i < input2.length() ; i++){
			if(!(input2.charAt(i) >= '0' && input2.charAt(i) <= '9')){
				isNumber = false ;
			}
		}

		if(input1.length() >= 9 || input2.length() >= 9){
			isNumber = false ;
		}

		return isNumber ;
	}

}