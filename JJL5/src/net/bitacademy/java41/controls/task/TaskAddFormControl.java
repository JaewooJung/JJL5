package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
@Component("/task/taskaddForm.do")
public class TaskAddFormControl implements PageControl {
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Map<String, String[]> params = (Map<String, String[]>)model.get("params");
		
	    model.put("pno", Integer.parseInt(params.get("pno")[0]));
		return "../task/taskadd.jsp";
		
	}
}
