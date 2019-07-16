package com.alibaba.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.executor.ResultExtractor;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.Participant;
import com.alibaba.entity.Pool;
import com.alibaba.entity.SystemUser;
import com.alibaba.service.ParticipantService;
import com.alibaba.util.Result;
import com.alibaba.util.StatusCode;



@Controller
@RequestMapping("/participant")
public class ParticipantController {
	
	@Autowired
	private ParticipantService participantService;
	
	@RequestMapping("/selectAllHasGetPariticipant")
	@ResponseBody 
	public Result selectAllHasGetPariticipant(){
		
		participantService.change();//随机选五个中签
		
		List <Participant>  participant_list=participantService.getallhasgetparticipant();
		if(participant_list!=null) {
			return Result.create(participant_list);
		}
		
		
		return Result.create(StatusCode.ERROR,"空数据");
		
	}
	
	@RequestMapping("/selectAllHasNotGetPariticipant")
	@ResponseBody 
	public Result selectAllHasNotGetPariticipant(){
		
		List <Participant>  participant_list=participantService.getallhasnotgetparticipant();
		if(participant_list!=null) {
			return Result.create(participant_list);
		}
		
		
		return Result.create(StatusCode.ERROR,"空数据");
		
	}
	
	@RequestMapping("/selectPariticipant.do")
	@ResponseBody 
	public List<Map<String, Object>> selectPariticipant(){
		return participantService.getParticipant();
	}
	
	public static int setwin;//设置单次中签人数
	
	@RequestMapping("/setwin")
	@ResponseBody 
	public Result setwin(String setwin) throws Exception{
		
		
		ParticipantController.setwin= Integer.parseInt(setwin); 
		
		System.out.println(ParticipantController.setwin);
		
		return Result.create(StatusCode.OK,"得到setwin",ParticipantController.setwin);
	}
	
	public static int showcontentdefinition1;//"显示中签人的信息"，勾了是1，没勾是0
	public static int showcontentdefinition2;//"显示未中签人的信息"，勾了是1，没勾是0
	
	@RequestMapping("/showcontentdefinition")
	@ResponseBody 
	public Result showcontentdefinition(String showcontentdefinition1,String showcontentdefinition2) throws Exception{
		System.out.println(showcontentdefinition1);
		System.out.println(showcontentdefinition2);
		
		if(showcontentdefinition1=="显示中签人的信息") {
			ParticipantController.showcontentdefinition1=1;
		}
		else {
			ParticipantController.showcontentdefinition1=0;
		}
		
		if(showcontentdefinition2=="显示未中签人的信息") {
			ParticipantController.showcontentdefinition2=1;
		}
		else {
			ParticipantController.showcontentdefinition2=0;
		}

		
		return Result.create(StatusCode.OK,"得到showcontentdefinition",showcontentdefinition1);
	}
	
	
	public static int participantinformationdefinition1;//"导入信息拥有姓名"，勾了是1，没勾是0
	public static int participantinformationdefinition2;//"导入信息拥有电话"，勾了是1，没勾是0
	public static int participantinformationdefinition3;//"导入信息拥有身份证"，勾了是1，没勾是0
	
	@RequestMapping("/participantinformationdefinition")
	@ResponseBody 
	public Result participantinformationdefinition(String participantinformationdefinition1,String participantinformationdefinition2,String participantinformationdefinition3) throws Exception{
		System.out.println(participantinformationdefinition1);
		System.out.println(participantinformationdefinition2);
		System.out.println(participantinformationdefinition3);

		if(participantinformationdefinition1=="导入信息拥有姓名") {
			ParticipantController.participantinformationdefinition1=1;
		}
		else {
			ParticipantController.participantinformationdefinition1=0;
		}
		

		if(participantinformationdefinition2=="导入信息拥有电话") {
			ParticipantController.participantinformationdefinition2=1;
		}
		else {
			ParticipantController.participantinformationdefinition2=0;
		}
		

		if(participantinformationdefinition3=="导入信息拥有身份证") {
			ParticipantController.participantinformationdefinition3=1;
		}
		else {
			ParticipantController.participantinformationdefinition3=0;
		}
		
		return Result.create(StatusCode.OK,"得到participantinformationdefinition");
	}
	
	
	@RequestMapping("/participantinformationimport")
	@ResponseBody 
	public Result participantinformationimport(String participantname,String participanttelephone,String participantidentifyid) throws Exception{
		
		System.out.println(participantname);
		System.out.println(participanttelephone);
		System.out.println(participantidentifyid);
		
		if(participantname!=null && participanttelephone!=null && participantidentifyid!=null) {
			int participant=participantService.getParticipantInformationImport1(participantname,participanttelephone,participantidentifyid);
		}
		else if(participantname!=null && participanttelephone!=null && participantidentifyid==null) {
			int participant=participantService.getParticipantInformationImport2(participantname,participanttelephone);
		}
		else if(participantname!=null && participanttelephone==null && participantidentifyid!=null) {
			int participant=participantService.getParticipantInformationImport3(participantname,participantidentifyid);
		}
		else if(participantname!=null && participanttelephone==null && participantidentifyid==null) {
			int participant=participantService.getParticipantInformationImport4(participantname);
		}
		else if(participantname==null && participanttelephone!=null && participantidentifyid!=null) {
			int participant=participantService.getParticipantInformationImport5(participanttelephone,participantidentifyid);
		}	
		else if(participantname==null && participanttelephone!=null && participantidentifyid==null) {
			int participant=participantService.getParticipantInformationImport6(participanttelephone);
		}
		else if(participantname==null && participanttelephone==null && participantidentifyid!=null) {
			int participant=participantService.getParticipantInformationImport7(participantidentifyid);
		}
		
		if(participantname!=null) {
			return Result.create(StatusCode.OK,"得到participantinformationimport1",participantname);
		}
		else {
			if(participanttelephone!=null){
				return Result.create(StatusCode.OK,"得到participantinformationimpor2",participanttelephone);
			}
			else {
				if(participantidentifyid!=null) {
					return Result.create(StatusCode.OK,"得到participantinformationimport3",participantidentifyid);
				}
				return Result.create(StatusCode.ERROR,"未得到participantinformationimport");
			}
		}
			
	}
	
}
