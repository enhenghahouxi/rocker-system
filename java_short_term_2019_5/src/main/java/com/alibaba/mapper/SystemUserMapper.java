package com.alibaba.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.alibaba.entity.SystemUser;


public interface SystemUserMapper {
	
	@Results(id = "systemMap", value = {
            @Result(property = "sysid", column = "sys_id", id = true),
            @Result(property = "sysname", column = "sys_name"),
            @Result(property = "syspassword", column = "sys_password")
    })
	
	//获取system表中所有的数据
	@Select("SELECT * FROM systemuser")
	public List<Map<String, Object>> getAllSystem();
	
	//这个把所有的数据库字段在java中进行了修改，
	//例子：数据库中是sys_id,在java中是sysid，以此类推
	
	
	
	@Select("select sys_name, sys_password from systemuser where sys_name=#{sys_name} and sys_password=#{sys_password};")
	public SystemUser getSystem(@Param("sys_name") String sys_name,@Param("sys_password") String sys_password);
	
	
	
}
