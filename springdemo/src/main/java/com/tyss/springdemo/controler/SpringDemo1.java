package com.tyss.springdemo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringDemo1 {
	
	@GetMapping("/")
	public String getPage(){
		return "Wellcome to viisolve";
	}

}
