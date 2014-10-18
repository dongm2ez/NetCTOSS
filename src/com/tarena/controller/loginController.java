package com.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class loginController extends BaseController{
	//µÇÂ¼³É¹¦
	public final static int SUCCESS = 0;
	//ÕËºÅ´íÎó
	public final static int ADMIN_CODE_ERROR = 1;
	//ÃÜÂë´íÎó
	public final static int PASSWORD_CODE_ERROR = 2;
	//ÑéÖ¤Âë´íÎó
	public final static int VERIFICATION_CODE_ERROR = 3;
	
	@RequestMapping("tologin.do")
	public String tologin(){
		return "login";
	}
}
