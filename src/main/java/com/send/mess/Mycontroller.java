package com.send.mess;

import java.util.Random;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.send.mess.entity.UserEntity;
import com.send.mess.service.OtpService;
import com.send.mess.service.UserService;


@Controller
public class Mycontroller {
	int otp;
	@Autowired
	UserService userService;
	
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
   @Autowired
	OtpService otpService;
	
	@GetMapping("/mess")
	public String getemail() {
	        
		System.out.println("chal gya");
		return "enterotp";
	}
	
	
	
	@GetMapping("/aaa")
	public String getotp(@RequestParam("email")String email) {
		
		
//		Random random = new Random();
//		setOtp(random.nextInt(999999));
//		otpService.sendEmailTest(getOtp(),email);
		System.out.println(email);
		System.out.println("kapila");
		return"otpcheck";
	}
	
	@GetMapping("/aa")
	public String getOtpVarification(@RequestParam("otp") String otpp) {
//		if (Integer.parseInt(otpp) == getOtp()) {
//			return "getmess";
//		} else {
//			return "otpcheck";
//		}
		return "getmess";
	}
//// optional not use	
//	@GetMapping("/otpcheck")
//	public String dum() {
//		System.out.println("URL '/otpcheck' triger");
//		return "redirect:/mess";
//	}
	
	@GetMapping("/add")
//	public String addData(@RequestParam("task")String task,@RequestParam("date")String date,@RequestParam("start")String start,@RequestParam("end")String end) {
	public String addData(@RequestParam("task")String task) {
	System.out.println(task);
//		System.out.println(date);
//		System.out.println(start);
//		System.out.println(end);
		System.out.println("cjdshiag");
		return "getmess";
		}
}
