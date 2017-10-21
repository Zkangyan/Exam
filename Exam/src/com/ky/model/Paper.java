package com.ky.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 试卷类
 * @author Administrator
 *
 */
@Entity
@Table(name="t_paper")
public class Paper {

	private int id;
	private String paperName; //试卷名字
	private Date joinDate; //加入时间
	//题目的集合
	private Set<Question> questions=new HashSet<Question>();
	
	@Id
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	//一套试卷对应很多题目   mappedBy="paper"-->对应 Question中的 
	//fetch 获取方式  立即加载  获取开始试卷的时候需要立即加载题目(默认为懒加载)
	@OneToMany(mappedBy="paper",fetch=FetchType.EAGER)
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
}
