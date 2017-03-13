package com.mmt.tourism.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

	private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public String ExceptionHandle(Exception ex, HttpServletResponse response) {
		response.setStatus(405);

		logger.error("程序出现异常",ex);
		
		return ex.getMessage();
	}
}
