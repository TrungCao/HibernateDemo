package vn.trung.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import vn.trung.model.Employee;

public class HibernateJavaConfiguration {
	private static final SessionFactory SESSIONFACTORY;

	static {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
		properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.put(Environment.URL,
				"jdbc:sqlserver://localhost:1433;databaseName=hibernate;trustServerCertificate=true");
		properties.put(Environment.USER, "TrungCT4");
		properties.put(Environment.PASS, "123654");
		
		properties.put(Environment.HBM2DDL_AUTO, "create");
		properties.put(Environment.SHOW_SQL, true);
		configuration.setProperties(properties);
		
		configuration.addAnnotatedClass(Employee.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		
		SESSIONFACTORY = configuration.buildSessionFactory(registry);
		
	}

	public static SessionFactory getSessionFactory() {
		return SESSIONFACTORY;
	}
	
	
}
