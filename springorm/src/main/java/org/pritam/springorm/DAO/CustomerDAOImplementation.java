package org.pritam.springorm.DAO;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDAOImplementation implements CustomerDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
