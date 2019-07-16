package com.alibaba.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;
import com.alibaba.mapper.PoolMapper;
import com.alibaba.service.PoolService;


@Service
public class PoolServiceImpl implements PoolService {
	
	@Autowired
	private PoolMapper poolMapper;
	
	/* (non-Javadoc)
	 * @see com.alibaba.service.impl.PoolService#getAll()
	 */
	@Override
	public List<Map<String, Object>> getAll(){
		return poolMapper.getAllPool();
	}
	
	public List<Map<String, Object>> getPool(){
		return poolMapper.getPool();
	}
	
	
	
}
