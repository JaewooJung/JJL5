package net.bitacademy.java41.controls.project;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;
@Component("/project/projectaddForm.do")
public class ProjectAddFormControl implements PageControl{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "../project/projectadd.jsp";
		
	}
}
