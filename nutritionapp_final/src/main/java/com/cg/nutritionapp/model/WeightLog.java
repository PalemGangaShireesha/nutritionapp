package com.cg.nutritionapp.model;


import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * In this class all the data in the module is stored and same is manipulated in all the classes in the app.
 * This model class is foundation of your WeightLog Module.
 * Also we provide defaults for weightLog here.
 * @author 
 *
 */
@Entity
public class WeightLog {
	/*
	 * Store your Weight Entry.
	 * Cannot be negative .
	 * Does work with decimal values.
	 */
	Integer weight;
	/*
	 * stores date of the creation of record.
	 * Does automatically from your device.
	 */
	LocalDate created_At;
	/**
	 * Stores date of updation of record.
	 */
	LocalDate updated_At;
	/*
	 * userid is the unique identification of user.
	 * Will be asked from user whenever they access any record.
	 */
	String userId;
	/**
	 * Provides initialization to module.
	 */
	public WeightLog() {
		super();
	}
	/**
	 * provides default values to the things user do not provide.
	 */
	public WeightLog(Integer weight, LocalDate created_At, LocalDate updated_At, String userId) {
		
		super();
		
		this.weight = weight;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.userId = userId;
	}
	
	/**
	 * Below are getters and setters methods for getting and storing data.
	 * getters and setters are for weight,created_At,updated_At,user_Id. 
	 * @return
	 */
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public LocalDate getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDate created_At) {
		this.created_At = created_At;
	}
	public LocalDate getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(LocalDate updated_At) {
		this.updated_At = updated_At;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * To String method to return all kind of  data in string format.
	 */
	@Override
	public String toString() {
		return "WeightLog [weight=" + weight + ", created_At=" + created_At + ", updated_At=" + updated_At + ", userId="
				+ userId + "]";
	}
	
	
	
}
