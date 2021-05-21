package com.cg.nutritionapp.serviceimpl;

import java.util.List;

import com.cg.nutritionapp.dao.PaymentDAO;
import com.cg.nutritionapp.daoimpl.PaymentDAOImpl;
import com.cg.nutritionapp.model.Payment;
import com.cg.nutritionapp.service.PaymentsService;
/**
 * This is a Service Implementation class of payments
 * @author 
 *
 */
public class PaymentsServiceImpl implements PaymentsService {
	private PaymentDAO paymentDAO;

	public PaymentsServiceImpl() {
		paymentDAO=new PaymentDAOImpl();
	}
	@Override
	public void addPayments(Payment payments) {
		paymentDAO.save(payments);

	}

	@Override
	public List<Payment> listPayments() {
		//return null;
		
		return paymentDAO.findAll();
	}

	@Override
	public Payment findPaymentsById(Long id) {
		return null;
	}

	@Override
	public void update(Payment payments) {
		paymentDAO.update(payments);
	}

}
