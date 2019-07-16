package com.alibaba.service;

import java.util.List;
import java.util.Map;

import com.alibaba.entity.SystemUser;

public interface SystemUserService {

	//查询所有system,service业务层调用mapper(即DAO组件层)
	List<Map<String, Object>> getAll();
	
	public SystemUser getSystem(String sys_name,String sys_password);
}