package com.ky.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ky.dao.StudentDao;
import com.ky.model.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private StudentDao studentDao=new StudentDao();
	
	private Student student;
	private String error;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	//登录的方法
	public String login()throws Exception{
		HttpSession session=request.getSession();
		Student currentUser=studentDao.login(student);
		if(currentUser==null){
			error="准考证号或密码错误";
			return ERROR;
		}else{
			session.setAttribute("currentUser", currentUser);
			return SUCCESS;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

}
