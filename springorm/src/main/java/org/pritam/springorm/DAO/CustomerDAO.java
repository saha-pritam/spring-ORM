package org.pritam.springorm.DAO;

import java.util.List;

import org.pritam.springorm.entity.Customer;

public interface CustomerDAO {
	public int insert(Customer customer);
	
	public Customer getCustomerById(int customerId);
	
	public List<Customer> getAllCustomer();

	public void update(Customer customer);
	
	public void delete(int customerId);
}
