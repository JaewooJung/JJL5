package net.bitacademy.java41.controls.task;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

public class TaskUpdateControl implements PageControl{
	TaskService taskService;
	
	public TaskUpdateControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");	
		Task task = (Task) session.getAttribute("taskUpdate");
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");
		
		Task taskUpdate = (Task) session.getAttribute("taskUpdate");
		
		taskUpdate
				  .setTitle(params.get("title")[0])
				  .setContent(params.get("content")[0])
			      .setUiprotourl(params.get("uiprotourl")[0])
				  .setStartDate(Date.valueOf(params.get("startdate")[0]))
				  .setEndDate(Date.valueOf(params.get("enddate")[0]))
				  .setStatus(Integer.parseInt(params.get("status")[0]));
		
		taskService.change(taskUpdate);
		return "redirect:../task/alltask.do?pno="+params.get("pno")[0];
			
		
	}

}
