package com.codefest.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codefest.main.validator.LoginScreenValidator;
import com.codefest.main.vo.HomeVO;

@Controller
public class HomeController { 
	
	public LoginScreenValidator loginScreenValidator;
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/index")
	public String welcome() {
		
		List<?> records = new ArrayList<>();
			Class<?> entityClass = null;
			Object entityObj = null;
			String sql = "Select * from CF_USER";
			try {
				entityClass = Class.forName("com.codefest.main.entity.CFUser");
				entityObj = entityClass.newInstance();
				records = jdbcTemplate.query(sql, new BeanPropertyRowMapper(entityObj.getClass()));
				System.out.println("size ******" + records.size());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} 
	    return "index";
	}
	
    @RequestMapping(value="/home" , method = RequestMethod.POST)
    public String hello(@RequestParam(value="userName", required=true) String userName1 ,@RequestParam(value="passWord", required=true) String passWord1, Model model) {

    	HomeVO homevoObject=new HomeVO();
        homevoObject.setUserName(userName1);
        homevoObject.setPassWord(passWord1);
        LoginScreenValidator loginValidation= new LoginScreenValidator();
        boolean validationStatus=loginScreenValidator.processValidation(homevoObject);
        //boolean validationStatus=loginValidation.processValidation(homevoObject);
        if(validationStatus==true){
        	model.addAttribute("userInfo", "Welcome "+homevoObject.getUserName());
        	return "userHomeScreen";
        }else{
        	System.out.println("test error");
        	model.addAttribute("errorMsg", "Incorrect Username and Password");
        	return "index";
        }
        
        
       
    }

}
