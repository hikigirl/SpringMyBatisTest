package com.test.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.model.MyBatisDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyBatisController {
	
	//의존주입
	private final MyBatisDAO dao;
	
	@GetMapping("/result.do")
	public String test() {
		
		System.out.println(dao != null);
		
		return "result"; //result.jsp 호출
	}
}
