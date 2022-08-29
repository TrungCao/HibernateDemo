package vn.trung;

import java.util.Iterator;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.trung.config.HibernateJavaConfiguration;
import vn.trung.model.Employee;

public class MainApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateJavaConfiguration.getSessionFactory();
		try {
			Employee employee = new Employee("trung");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(employee);

			session.getTransaction().commit();
			
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
