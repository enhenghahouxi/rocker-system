package com.alibaba.controller;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.SystemUser;
import com.alibaba.service.SystemUserService;
import com.alibaba.util.Result;
import com.alibaba.util.StatusCode;



@Controller
//@Controller用于标记在一个类上，使用它标记的类就是一个SpringMvc Controller对象，
//分发处理器会扫描使用该注解的类的方法，并检测该方法是否使用了@RequestMapping注解。
@RequestMapping("/systemuser")

public class SystemUserController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	//获取表中所有数据
	@RequestMapping("/selectAllSystem.do")
	@ResponseBody//把下面方法的数据变成json
	public List<Map<String, Object>> selectAllSystem(){
		return systemUserService.getAll();
	}
	
	@RequestMapping("/selectSystem")
	@ResponseBody//把下面方法的数据变成json
	public Result selectSystem(String sys_name,String sys_password) throws Exception{
		SystemUser systemuser=systemUserService.getSystem(sys_name, sys_password);
		if(systemuser!=null) {
			return Result.create(StatusCode.OK,"登录成功",systemuser);
		}
		else {
			return Result.create(StatusCode.ERROR,"登录失败，用户名或密码错误");
		}
	}
//	@RequestMapping("/get-book-by-id")
//    public Result getBookById(@RequestBody JSONObject jsonObject) {
//        Integer bookId = Integer.parseInt((String) jsonObject.get("bookId"));
//        Book book = bookService.getBookById(bookId);
//        if (book != null)
//            return Result.success(book);
//        else
//            return Result.fail("The book may not exist.");
//    }
	
}
