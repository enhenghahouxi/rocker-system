package com.alibaba.service;

import java.util.List;
import java.util.Map;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;

public interface PoolService {

	List<Map<String, Object>> getAll();
	
	List<Map<String, Object>> getPool();
	
	
	
}