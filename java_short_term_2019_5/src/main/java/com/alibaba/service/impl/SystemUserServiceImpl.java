package com.alibaba.service.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.SystemUser;
import com.alibaba.mapper.SystemUserMapper;
import com.alibaba.service.SystemUserService;
import com.alibaba.entity.SystemUser;

@Service
// @Service用于标注业务层组件
public class SystemUserServiceImpl implements SystemUserService {
	
	
	@Autowired
	//@Autowired是用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法注入所需的外部资源。
	//@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
	private SystemUserMapper systemUserMapper;
	
	//查询所有system,service业务层调用mapper(即DAO组件层)
	/* (non-Javadoc)
	 * @see com.alibaba.service.impl.SystemService#getAll()
	 */
	@Override
	public List<Map<String, Object>> getAll(){
		return systemUserMapper.getAllSystem();
	}
	
	public SystemUser getSystem(String sys_name,String sys_password){
		return systemUserMapper.getSystem(sys_name, sys_password);
	}
	
}
