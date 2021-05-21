package com.cg.nutritionapp.dao;

import java.util.List;

import com.cg.nutritionapp.model.WeightLog;

public interface WeightLogDAO {

/**
 *  To save all the value to weightlog.
 */
	WeightLog save(WeightLog weightLog);
/**
*   To display the values in weightlog.
*/
	List<WeightLog> findAll()  ;
/**
 * 	To update values for weightLog.
 */ 
  WeightLog update(WeightLog weightLog) ;
  /**
   * 
   * To delete your weight log.
   */
 
	WeightLog delete(WeightLog weightLog);

}
