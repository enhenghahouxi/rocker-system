package com.alibaba.service;

import java.util.List;
import java.util.Map;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;

public interface ParticipantService {

	public int change();
	
	List<Map<String, Object>> getParticipant();
	
	
	public int getParticipantInformationImport1(String participantname,String participantphone,String participantidentifyid);
	
	public int getParticipantInformationImport2(String participantname,String participantphone);
	
	public int getParticipantInformationImport3(String participantname,String participantidentifyid);
	
	public int getParticipantInformationImport4(String participantname);
	
	public int getParticipantInformationImport5(String participantphone,String participantidentifyid);
	
	public int getParticipantInformationImport6(String participantphone);
	
	public int getParticipantInformationImport7(String participantidentifyid);

	public List<Participant> getallhasgetparticipant();
	
	public List<Participant> getallhasnotgetparticipant();
	
}