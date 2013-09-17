package net.bitacademy.java41.controls.task;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

public class TaskDetailControl implements PageControl{
	TaskService taskService;
	
	public TaskDetailControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");
		
		Task task = taskService.getTask(Integer.parseInt(params.get("tno")[0]));
		HttpSession session = (HttpSession) model.get("session");

		if (task != null) {
			session.setAttribute("taskdetail", task);
			return "../task/taskdetail.jsp";
		
		} else {
			return "../error.jsp";
		}
	}
}
