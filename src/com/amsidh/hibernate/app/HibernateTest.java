package com.amsidh.hibernate.app;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.Address;
import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Second User");
		user.setDateOfBirth(new Date());
		user.setDescription("Description goes here for the user");
		
		
		Address address=new Address();
		address.setCity("Pune");
		address.setPincode(1235);
		address.setState("MH");
		address.setStreet("Kate Puram");
		address.setUserDetails(user);
		user.setAddress(address);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(address);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
