package com.rahul.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rahul.dto.Address;
import com.rahul.dto.Student;

public class CrudOperation {
	
	public static void main(String[] args) {

		Session session = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
			session = sessionFactory.openSession();
			Transaction tx =session.beginTransaction();
			//session.save(new Student(1,"rahul",new Address("Balewadi","Pune",411045)));
			session.save(new Student(1,"rahul",new Address("Balewadi","Pune",411045)));
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				
				session.close();
		}

	}
}
