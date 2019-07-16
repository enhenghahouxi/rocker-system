package com.alibaba.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;

public interface PoolMapper {
	
	@Select("SELECT * FROM pool")
	public List<Map<String, Object>> getAllPool();
	
	@Results(id = "poolMap", value = {
            @Result(property = "poolid", column = "pool_id", id = true),
            @Result(property = "poolname", column = "pool_name"),
            @Result(property = "pooltelephone", column = "pool_telephone"),
            @Result(property = "poolidentityid", column = "pool_identityid"),
            @Result(property = "poolhasget", column = "pool_hasget")
    })
	
	@Select("select pool_name from pool;")
	public List<Map<String, Object>> getPool();
	
	
}
