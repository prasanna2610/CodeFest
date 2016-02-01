package com.codefest.main.validator;

import org.springframework.stereotype.Component;

import com.codefest.main.vo.HomeVO;

@Component
public class LoginScreenValidator {

public boolean processValidation(HomeVO loginCheck){
	if(loginCheck.getUserName().matches("sakthi") && loginCheck.getPassWord().matches("123")){
		return true;
	}else{
		return false;
	}	
}
	
	
}
