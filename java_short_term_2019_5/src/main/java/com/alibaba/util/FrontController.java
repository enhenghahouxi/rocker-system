package com.alibaba.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
//@Controller用于标记在一个类上，使用它标记的类就是一个SpringMvc Controller对象，
//分发处理器会扫描使用该注解的类的方法，并检测该方法是否使用了@RequestMapping注解。
public class FrontController {
	
	@RequestMapping("/test1.do")
	//使用@RequestMapping注解的方法才是处理请求的处理器,就是要访问的网页的路径
	public void test1() {
		System.out.println("hello springboot!!!");
	}
	
	@RequestMapping("/test2.do")
	@ResponseBody
	//该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后
	//，写入到Response对象的body数据区。
	public String test2() {
		return "hello springboot!!!";
	}
	
}
