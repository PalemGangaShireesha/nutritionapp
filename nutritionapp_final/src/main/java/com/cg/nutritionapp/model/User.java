package com.cg.nutritionapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * A model class used to hold and transfer attribute values from one layer to other.
 * @author 
 *
 */
@Entity
public class User {
	/*
	 * id is used for storing automatically generated id
	 */
	//@Id @GeneratedValue
	private Long id;
	/**
	 * userIdentification is unique and is String
	 */
	private String userIdentification;
	/**
	 * name is of type String and used to store user's name
	 */
	private String name;
	/**
	 * contact is of type String and store user contact details
	 */
	private String contact;
	/**
	 * gender is of type String and stores gender value
	 */
	private String gender;
	/**
	 * dob is Date of Birth and is of type String
	 */
	private String dob;
	/**
	 * photo is used to store filename of with jpg/png extension
	 */
	private String photo;
	/**
	 * email stores email of user
	 */
	private String email;
	/**
	 * Role specifies whether a user is customer or a dietitian 
	 */
	private String role;
	/**
	 * status defines if any user is active or blocked
	 */
	private String status;
	/**
	 * weight is of type double and store weight of user
	 */
	private Double weight;
	/**
	 * height is also of type double and stores height
	 */
	private Double height;
	/**
	 * diateryOrientation defines how the diet plan of the specific users is
	 */
	private String diateryOrientation;
	/**
	 * intensity is a number which defines the ability to do workout on the scale of 1-10
	 */
	private Double intensity;
	/**
	 * goal defines the specific goal set by user or dietitian 
	 */
	private String goal;
	/**
	 * number of hours a person can workout
	 */
	private String workOutTime;
	/**
	 * time by which user wakes up
	 */
	private String wakeUpTime;
	/**
	 * time by which user goes to sleep
	 */
	private String sleepTime;
	/**
	 * medical condition defines if a user is having any medical conditions or not
	 */
	private String medicalConditon;
	/**
	 * this is a String type stores value if a person is allergic to something
	 */
	private String allergicTo;
	/**
	 * loginNmae is the login name specified by user
	 */
	private String loginName;
	/**
	 * password is the password set by user
	 */
	private String password;


	/**
	 * default Constructor
	 */
	public User() {
		super();
	}

	/**
	 * Constructor with parameters excluding id
	 * @param userIdentification
	 * @param name
	 * @param contact
	 * @param gender
	 * @param dob
	 * @param photo
	 * @param email
	 * @param role
	 * @param status
	 * @param weight
	 * @param height
	 * @param diateryOrientation
	 * @param intensity
	 * @param goal
	 * @param workOutTime
	 * @param wakeUpTime
	 * @param sleepTiem
	 * @param medicalConditon
	 * @param allergicTo
	 * @param loginName
	 * @param password
	 */
	public User(String userIdentification, String name, String contact, String gender, String dob, String photo,
			String email, String role, String status, Double weight, Double height, String diateryOrientation,
			Double intensity, String goal, String workOutTime, String wakeUpTime, String sleepTime,
			String medicalConditon, String allergicTo, String loginName, String password) {
		super();
		//this.id = id;
		this.userIdentification = userIdentification;
		this.name = name;
		this.contact = contact;
		this.gender = gender;
		this.dob = dob;
		this.photo = photo;
		this.email = email;
		this.role = role;
		this.status = status;
		this.weight = weight;
		this.height = height;
		this.diateryOrientation = diateryOrientation;
		this.intensity = intensity;
		this.goal = goal;
		this.workOutTime = workOutTime;
		this.wakeUpTime = wakeUpTime;
		this.sleepTime = sleepTime;
		this.medicalConditon = medicalConditon;
		this.allergicTo = allergicTo;
		this.loginName = loginName;
		this.password = password;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserIdentification() {
		return userIdentification;
	}
	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getDiateryOrientation() {
		return diateryOrientation;
	}
	public void setDiateryOrientation(String diateryOrientation) {
		this.diateryOrientation = diateryOrientation;
	}
	public Double getIntensity() {
		return intensity;
	}
	public void setIntensity(Double intensity) {
		this.intensity = intensity;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getWorkOutTime() {
		return workOutTime;
	}
	public void setWorkOutTime(String workOutTime) {
		this.workOutTime = workOutTime;
	}
	public String getWakeUpTime() {
		return wakeUpTime;
	}
	public void setWakeUpTime(String wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
	}
	public String getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}
	public String getMedicalConditon() {
		return medicalConditon;
	}
	public void setMedicalConditon(String medicalConditon) {
		this.medicalConditon = medicalConditon;
	}
	public String getAllergicTo() {
		return allergicTo;
	}
	public void setAllergicTo(String allergicTo) {
		this.allergicTo = allergicTo;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userIdentification=" + userIdentification + ", name=" + name + ", contact="
				+ contact + ", gender=" + gender + ", dob=" + dob + ", photo=" + photo + ", email=" + email + ", role="
				+ role + ", status=" + status + ", weight=" + weight + ", height=" + height + ", diateryOrientation="
				+ diateryOrientation + ", intensity=" + intensity + ", goal=" + goal + ", workOutTime=" + workOutTime
				+ ", wakeUpTime=" + wakeUpTime + ", sleepTime=" + sleepTime + ", medicalConditon=" + medicalConditon
				+ ", allergicTo=" + allergicTo + ", loginName=" + loginName + ", password=" + password + "]";
	}

}
