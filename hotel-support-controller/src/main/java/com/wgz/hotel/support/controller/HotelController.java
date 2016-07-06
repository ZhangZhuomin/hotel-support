package com.wgz.hotel.support.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@EnableAutoConfiguration 
@Component
@RequestMapping("/ctrl")
public class HotelController implements InitializingBean {
	@Autowired
	private ObjectMapper objectMapper;
	@Override	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}
	@RequestMapping("/")
	public String login() throws JsonProcessingException{
			
		String res="Hello hotel";
		return objectMapper.writeValueAsString(res);
		
	}
	

}
