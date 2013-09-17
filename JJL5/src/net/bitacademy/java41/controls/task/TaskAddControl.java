package net.bitacademy.java41.controls.task;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.controls.member.MemberAddControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;

public class TaskAddControl implements PageControl{
	TaskService taskService;
	
	public TaskAddControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");
		
		int status;
		if(params.get("status")[0].endsWith("")){
			status = 0;
		}
		else{
			status = Integer.parseInt(params.get("status")[0]);
		}
		
		Task task = new Task()
		.setPno(Integer.parseInt(params.get("pno")[0]))
		.setTitle(params.get("title")[0])
		.setUiprotourl(params.get("uiprotourl")[0])
		.setContent(params.get("content")[0])
		.setStartDate(Date.valueOf(params.get("startdate")[0]))
	    .setEndDate(Date.valueOf(params.get("enddate")[0]))
		.setStatus(status);
		
		taskService.add(task);
	
		return "redirect:../task/alltask.do?pno="+params.get("pno")[0];
	}}