package com.alibaba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;
import com.alibaba.service.PoolService;
import com.alibaba.util.Result;
import com.alibaba.util.StatusCode;


@Controller
@RequestMapping("/pool/")
public class PoolController {
	
	@Autowired
	private PoolService poolService;
	
	@RequestMapping("/selectAllPool.do")
	@ResponseBody
	public List<Map<String, Object>> selectAllPool(){
		return poolService.getAll();
	}
	
	@RequestMapping("/selectPool.do")
	@ResponseBody
	public List<Map<String, Object>> selectPool(){
		return poolService.getPool();
	}
	
	
	
}
