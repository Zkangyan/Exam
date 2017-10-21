package com.ky.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ky.model.Student;
import com.ky.util.HibernateUtil;


public class StudentDao {

	public Student login(Student student)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();//开启
		//hql
		Query query=session.createQuery("from Student as s where s.id=:id and s.password=:password");
		query.setString("id", student.getId());
		query.setString("password", student.getPassword());
		Student resultStu=(Student)query.uniqueResult(); //返回唯一的结果 一条
		session.getTransaction().commit(); //结束并提交
		return resultStu;
	}
}
