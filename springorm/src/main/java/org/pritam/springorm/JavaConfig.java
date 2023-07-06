package org.pritam.springorm;

import org.pritam.springorm.DAO.CustomerDAO;
import org.pritam.springorm.DAO.CustomerDAOImplementation;
import org.pritam.springorm.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JavaConfig {
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springorm");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("9er$Y%F49yD4");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDriverManagerDataSource());
		localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.hbm2ddl.auto", "create");
		localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.show_sql", "true");
		localSessionFactoryBean.getHibernateProperties().setProperty("hibernate.format_sql", "true");
		localSessionFactoryBean.setAnnotatedClasses(Customer.class);
		return localSessionFactoryBean;
	}
	
	@Bean
    public HibernateTransactionManager getHibernateTransactionManager() {
    	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    	hibernateTransactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
    	return hibernateTransactionManager;
    }
	
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	
	@Bean("customerDAO")
	public CustomerDAO getCustomerDAO() {
		CustomerDAOImplementation customerDAOImplementation = new CustomerDAOImplementation();
		customerDAOImplementation.setHibernateTemplate(getHibernateTemplate());
		return customerDAOImplementation;
	}

}
