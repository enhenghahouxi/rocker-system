package com.alibaba.service.impl;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;
import com.alibaba.mapper.ParticipantMapper;
import com.alibaba.service.ParticipantService;


@Service
public class ParticipantServiceImpl implements ParticipantService {
	 
	@Autowired
	private ParticipantMapper participantMapper;
	
	
	/* (non-Javadoc)
	 * @see com.alibaba.service.impl.ParticipantService#getAll()
	 */
	@Override
	public List<Participant> getallhasgetparticipant(){
		
		List<Participant> list = participantMapper.getAllHasGetParticipant();
		return list;
	
	}
	
	public List<Participant> getallhasnotgetparticipant(){
		return participantMapper.getAllHasNotGetParticipant();
	}
	
	public int change(){
		List<Participant> list = participantMapper.change();
		if (list != null) {
			for (Participant participant : list) {
				System.out.println(participant.getPar_id());
				participantMapper.update(participant.getPar_id());
				
			}
		}
		return 1;
	}
	
	public List<Map<String, Object>> getParticipant(){
		return participantMapper.getParticipant();
	}
	
	public int getParticipantInformationImport1(String participantname,String participantphone,String participantidentifyid){
		return participantMapper.getparticipantinformationimport1(participantname,participantphone,participantidentifyid);
	}
	
	public int getParticipantInformationImport2(String participantname,String participantphone) {
		return participantMapper.getparticipantinformationimport2(participantname,participantphone);
	};
	
	public int getParticipantInformationImport3(String participantname,String participantidentifyid) {
		return participantMapper.getparticipantinformationimport3(participantname,participantidentifyid);
	};
	
	public int getParticipantInformationImport4(String participantname) {
		return participantMapper.getparticipantinformationimport4(participantname);
	};
	
	public int getParticipantInformationImport5(String participantphone,String participantidentifyid) {
		return participantMapper.getparticipantinformationimport5(participantphone,participantidentifyid);
	};
	
	public int getParticipantInformationImport6(String participantphone) {
		return participantMapper.getparticipantinformationimport6(participantphone);
	};
	
	public int getParticipantInformationImport7(String participantidentifyid) {
		return participantMapper.getparticipantinformationimport7(participantidentifyid);
	};
	
}
