package net.bitacademy.java41.controls.task;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;
@Component("/task/taskdelete.do")
public class TaskDeleteControl implements PageControl{
	TaskService taskService;
	
	public TaskDeleteControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");

		taskService.remove(Integer.parseInt(params.get("tno")[0]));
		
		return "../task/alltask.do?pno="+params.get("pno")[0];
		
	}
}
