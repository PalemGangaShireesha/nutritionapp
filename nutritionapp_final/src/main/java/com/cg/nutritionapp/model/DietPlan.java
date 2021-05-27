package com.cg.nutritionapp.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cg.nutritionapp.exceptions.DietPlanException;

/**
 * It is the model class for dietPlan module that represents an dietPlan
 * contains data member and respective getter setters.
 */
public class DietPlan {
	
	Long id;
	/**
	 * Id of the user.
	 * Id should never be negative.
	 * In case user enter negative Id, he should be reported with DietPlanException.
	 */
	String userId;
	String slots;
	String foodType;
	double proteinRatio;
	double fatRatio;
	double carbsRatio;
	double total;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	
	private User users;
	

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}


	/**
	 * Constructor for instantiation of DietPlan object with all fields
	 * @param id
	 * @param userId
	 * @param slots
	 * @param foodType
	 * @param proteinRatio
	 * @param fatRatio
	 * @param carbsRatio
	 * @param total
	 * @throws DietPlanException
	 */
	public DietPlan(Long id, String userId, String slots, String foodType, double proteinRatio, double fatRatio,
			double carbsRatio, double total) throws DietPlanException {
		
		this.id = id;
		this.userId = userId;
		this.slots = slots;
		this.foodType = foodType;
		this.proteinRatio = proteinRatio;
		this.fatRatio = fatRatio;
		this.carbsRatio = carbsRatio;
		this.total = total;
	}

	/**
	 * default constructor for creating instance only.
	 */
	public DietPlan() {
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getProteinRatio() {
		return proteinRatio;
	}

	public void setProteinRatio(double proteinRatio) {
		this.proteinRatio = proteinRatio;
	}

	public double getFatRatio() {
		return fatRatio;
	}

	public void setFatRatio(double fatRatio) {
		this.fatRatio = fatRatio;
	}

	public double getCarbsRatio() {
		return carbsRatio;
	}

	public void setCarbsRatio(double carbsRatio) {
		this.carbsRatio = carbsRatio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DietPlan [id=" + id + ", userId=" + userId + ", slots=" + slots + ", foodType=" + foodType
				+ ", proteinRatio=" + proteinRatio + ", fatRatio=" + fatRatio + ", carbsRatio=" + carbsRatio
				+ ", total=" + total + "]";
	}


}
