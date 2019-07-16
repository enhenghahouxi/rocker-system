package com.alibaba.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.alibaba.controller.ParticipantController;
import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;

@Repository
public interface ParticipantMapper {
	
	String participantinformationimport = null;
	
	
	@Select("SELECT par_id,par_name,par_telephone,par_identityid,par_hasget FROM participant where par_hasget=1")
	@Results(id = "participantMap", value = {
            @Result(property = "par_id", column = "par_id", id = true),
            @Result(property = "par_name", column = "par_name"),
            @Result(property = "par_telephone", column = "par_telephone"),
            @Result(property = "par_identityid", column = "par_identityid"),
            @Result(property = "par_hasget", column = "par_hasget")
    })
	public List<Participant> getAllHasGetParticipant();
	
	@Select("SELECT par_id,par_name,par_telephone,par_identityid,par_hasget FROM participant where par_hasget=0")
	@ResultMap("participantMap")
	public List<Participant> getAllHasNotGetParticipant();
	
	@Select("SELECT * FROM participant ORDER BY RAND() LIMIT 5")
	@ResultMap("participantMap")
	public List<Participant> change();
	
	@Select("UPDATE participant SET par_hasget = 1 WHERE par_id = #{par_Id}")
	public Integer update(@Param("par_Id") int par_Id);
	
	
	@Select("select par_name from participant;")
	public List<Map<String, Object>> getParticipant();
	
	@Insert("INSERT INTO participant(par_name,par_telephone,par_identityid,par_hasget) VALUES(#{participantname},#{participantphone},#{participantidentifyid},'0');")
	public int getparticipantinformationimport1(@Param("participantname") String participantname,@Param("participantphone") String participantphone,@Param("participantidentifyid") String participantidentifyid);
	
	@Insert("INSERT INTO participant(par_name,par_telephone,par_hasget) VALUES(#{participantname},#{participantphone},'0');")
	public int getparticipantinformationimport2(@Param("participantname") String participantname,@Param("participantphone") String participantphone);
	
	@Insert("INSERT INTO participant(par_name,par_identityid,par_hasget) VALUES(#{participantname},#{participantidentifyid},'0');")
	public int getparticipantinformationimport3(@Param("participantname") String participantname,@Param("participantidentifyid") String participantidentifyid);
	
	@Insert("INSERT INTO participant(par_name,par_hasget) VALUES(#{participantname},'0');")
	public int getparticipantinformationimport4(@Param("participantname") String participantname);
	
	@Insert("INSERT INTO participant(par_telephone,par_identityid,par_hasget) VALUES(#{participantphone},#{participantidentifyid},'0');")
	public int getparticipantinformationimport5(@Param("participantphone") String participantphone,@Param("participantidentifyid") String participantidentifyid);
	
	@Insert("INSERT INTO participant(par_telephone,par_hasget) VALUES(#{participantphone},'0');")
	public int getparticipantinformationimport6(@Param("participantphone") String participantphone);
	
	@Insert("INSERT INTO participant(par_identityid,par_hasget) VALUES(#{participantidentifyid},'0');")
	public int getparticipantinformationimport7(@Param("participantidentifyid") String participantidentifyid);
	
}
