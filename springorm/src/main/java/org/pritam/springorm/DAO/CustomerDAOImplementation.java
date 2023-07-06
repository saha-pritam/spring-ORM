package org.pritam.springorm.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.pritam.springorm.entity.Customer;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDAOImplementation implements CustomerDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(Customer customer) {
		int result = (Integer)hibernateTemplate.save(customer);
		System.out.println("Row Inserted...");
		return result;
	}
	
	public Customer getCustomerById(int customerId) {
		Customer c = hibernateTemplate.get(Customer.class, customerId);
		return c;
	}
	
    public List<Customer> getAllCustomer() {
		List<Customer> customers = hibernateTemplate.loadAll(Customer.class);
		return customers;
	}

}
