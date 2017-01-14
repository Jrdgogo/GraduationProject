package com.mmt.tourism.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value={Exception.class})
	@ResponseBody
	public String ExceptionHandle(Exception ex,HttpServletResponse response){
		response.setStatus(444);
		return ex.getMessage();
	}
}
