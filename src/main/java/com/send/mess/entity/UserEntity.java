package com.send.mess.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todolist")
public class UserEntity {

	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	String email;
	String workName;
	int date;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	int startTime;
	int endTime;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public UserEntity() {
		super();
		
	}
	
}
