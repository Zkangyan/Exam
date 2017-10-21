package com.ky.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 考试实体
 * @author Administrator
 *
 */
@Entity
@Table(name="t_exam")
public class Exam {

	private int id;  
	private Student student; //学生实体类
	private Paper paper;    //试卷实体
	private int singleScore; //单选得分
	private int moreScore;  //多选得分
	private int score;   //总分
	private Date examDate; //考试时间
	
	@Id
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne    //多对一 
	@JoinColumn(name="studentId") //外键
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne
	@JoinColumn(name="paperId")
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public int getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}
	public int getMoreScore() {
		return moreScore;
	}
	public void setMoreScore(int moreScore) {
		this.moreScore = moreScore;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

}
