package net.bitacademy.java41.controls.task;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.controls.member.MemberAddControl;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;
@Component("/task/taskadd.do")
public class TaskAddControl implements PageControl{
	String rootRealPath;
	TaskService taskService;
	long currTime = 0;
	int count = 0;

	public void setRootRealPath(String rootRealPath) {
		this.rootRealPath = rootRealPath;
		System.out.println(rootRealPath);
	}

	public TaskAddControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String,Object> params = 
		(Map<String,Object>)model.get("params");



		int status;
		if(((String) params.get("status")).endsWith("")){
			status = 0;
		}
		else{
			status = Integer.parseInt((String) params.get("status"));
		}

		Task task = new Task()
		.setPno(Integer.parseInt((String) params.get("pno")))
		.setTitle((String) params.get("title"))
		.setContent((String)params.get("content"))
		.setStartDate(Date.valueOf((String)params.get("startdate")))
		.setEndDate(Date.valueOf((String)params.get("enddate")))
		.setStatus(status);

		System.out.println(params.get("uiprotourl"));
		if((FileItem)params.get("uiprotourl") != null){

			FileItem photo = (FileItem)params.get("uiprotourl");
			String filename = this.getNewFileName();
			String path = rootRealPath + "file/" + filename;
			photo.write(new File(path) );
			task.setUiprotourl(filename);
		}

		taskService.add(task);


		return "redirect:../task/alltask.do?pno="+params.get("pno");
	}

	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "task_" + millis + "_" + (++count);
	}


}