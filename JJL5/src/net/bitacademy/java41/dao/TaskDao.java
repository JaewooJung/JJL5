package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.Task;
import net.bitacademy.java41.vo.Task;
import net.bitacademy.java41.vo.Task;
import net.bitacademy.java41.vo.Task;

public class TaskDao {
DBConnectionPool conPool;
	
	public TaskDao setDBConnectionPool(DBConnectionPool conPool) {
		this.conPool = conPool;
		return this;
	}
	
	public TaskDao() {	}
	
	public TaskDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}
	
	public List<Task> list(int pno) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Task> list = new ArrayList<Task>();

		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM SPMS_TASKS where PNO=" + pno);
			
			Task t = null;
			while(rs.next()) {
				t = new Task();
				t.setTno(rs.getInt("TNO"));
				t.setPno(rs.getInt("PNO"));
				t.setTitle(rs.getString("TITLE"));
				t.setUiprotourl(rs.getString("UIPROTOURL"));
				t.setContent(rs.getString("CONTENT"));
				t.setStartDate(rs.getDate("START_DATE"));
				t.setEndDate(rs.getDate("END_DATE"));
				t.setStatus(rs.getInt("STATUS"));
				list.add(t);
			}
			
			return list;
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	public int add(Task task) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"insert into SPMS_TASKS("
				+ " PNO,TITLE,UIPROTOURL,CONTENT,START_DATE,"
				+ " END_DATE,STATUS)"
				+ " values(?,?,?,?,?,?,?)");
			stmt.setInt(1, task.getPno());
			stmt.setString(2, task.getTitle());
			stmt.setString(3, task.getUiprotourl());
			stmt.setString(4, task.getContent());
			stmt.setDate(5, task.getStartDate());
			stmt.setDate(6, task.getEndDate());
			stmt.setInt(7, task.getStatus());
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	public Task getTask(int tno) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"select * from SPMS_TASKS "
				+ " where TNO=?"); // ? -> in-parameter
			stmt.setInt(1, tno);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Task t = new Task();
				t.setTno(rs.getInt("TNO"));
				t.setPno(rs.getInt("PNO"));
				t.setTitle(rs.getString("TITLE"));
				t.setUiprotourl(rs.getString("UIPROTOURL"));
				t.setContent(rs.getString("CONTENT"));
				t.setStartDate(rs.getDate("START_DATE"));
				t.setEndDate(rs.getDate("End_DATE"));
				t.setStatus(rs.getInt("STATUS"));
				return t;
				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}		
	}
	public int change(Task task) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			
			stmt = con.prepareStatement(
					"update SPMS_TASKS set PNO=?, TITLE=?, UIPROTOURL=?, CONTENT=?, START_DATE=?, END_DATE=?, STATUS=? where TNO = ?");
				stmt.setInt(1, task.getPno());
				stmt.setString(2, task.getTitle());
				stmt.setString(3, task.getUiprotourl());
				stmt.setString(4, task.getContent());
				stmt.setDate(5, task.getStartDate());
				stmt.setDate(6, task.getEndDate());
				stmt.setInt(7, task.getStatus());
				stmt.setInt(8, task.getTno());
			
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	public int remove(int tno) throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			
			return stmt.executeUpdate(
				"delete from SPMS_TASKS"
				+ " where TNO=" + tno);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}


}
