package net.bitacademy.java41.controls.task;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;
@Component("/task/taskupdateForm.do")
public class TaskUpdateFormControl implements PageControl{
	TaskService taskService;
	
	public TaskUpdateFormControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");
		
		Task task = taskService.getTask(Integer.parseInt(params.get("tno")[0]));
		HttpSession session = (HttpSession) model.get("session");
		session.setAttribute("taskUpdate", task);
		
		return "redirect:../task/taskUpdateForm.jsp";
		
	}

}
