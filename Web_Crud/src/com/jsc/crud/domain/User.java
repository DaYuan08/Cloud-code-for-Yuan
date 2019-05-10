package com.jsc.crud.domain;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private double workExperiencesex;
	private int sex;
	private String headerImg;
	private String birthDay;
	private Date createTime;
	private Date updateTime;
	
	public User() {
		super();
	}
	public User(String name, double workExperiencesex, int sex, String headerImg, String birthDay) {
		super();
		this.name = name;
		this.workExperiencesex = workExperiencesex;
		this.sex = sex;
		this.headerImg = headerImg;
		this.birthDay = birthDay;
	}
	public User(int id, String name, double workExperiencesex, int sex, String headerImg, String birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.workExperiencesex = workExperiencesex;
		this.sex = sex;
		this.headerImg = headerImg;
		this.birthDay = birthDay;
	}
	public User(int id, String name, double workExperiencesex, int sex, String headerImg, String birthDay,
			Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.workExperiencesex = workExperiencesex;
		this.sex = sex;
		this.headerImg = headerImg;
		this.birthDay = birthDay;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWorkExperiencesex() {
		return workExperiencesex;
	}
	public void setWorkExperiencesex(double workExperiencesex) {
		this.workExperiencesex = workExperiencesex;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHeaderImg() {
		return headerImg;
	}
	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", workExperiencesex=" + workExperiencesex + ", sex=" + sex
				+ ", headerImg=" + headerImg + ", birthDay=" + birthDay + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
}
