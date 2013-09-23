package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

@Component
public class TaskService {
	TaskDao taskDao;
	DBConnectionPool dbPool;

	public TaskService setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
		return this;
	}
	public TaskService setDBConnectionPool(DBConnectionPool dbPool) {
		this.dbPool = dbPool;
		return this;
	}
	public List<Task> list(int pno) throws Exception {
		return taskDao.list(pno);
	}

	public int add(Task task) throws Exception {
		return taskDao.add(task);
	}

	public Task getTask(int tno) throws Exception {
		return taskDao.getTask(tno);
	}

	public int change(Task taskUpdate)throws Exception  {
		return taskDao.change(taskUpdate);		
	}

	public int remove(int tno) throws Exception {
		return taskDao.remove(tno);
		
	}

	
}
