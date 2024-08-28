package com.hibernate.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.mappings.onetoone.dto.foreignKey.AccountEntity;
import com.hibernate.mappings.onetoone.dto.foreignKey.BankEntity;
import com.hibernate.mappings.onetoone.dto.foreignKey.EmployeeEntity;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try (FileInputStream file = new FileInputStream("D:\\Git_Source\\java-frameworks-training\\hibernate\\db.properties")) {

				Properties props = new Properties();
				props.load(file);
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, props.getProperty("driver_class"));
				settings.put(Environment.URL, props.getProperty("url"));
				settings.put(Environment.USER, props.getProperty("username"));
				settings.put(Environment.PASS, props.getProperty("password"));
				settings.put(Environment.DIALECT, props.getProperty("dialect"));

				settings.put(Environment.SHOW_SQL, props.getProperty("show_sql"));

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, props.getProperty("hbm2ddl"));

				Configuration configuration = new Configuration();
				configuration.setProperties(settings);

				configuration.addAnnotatedClass(AccountEntity.class);
				configuration.addAnnotatedClass(BankEntity.class);
				configuration.addAnnotatedClass(EmployeeEntity.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				System.out.println("Sucessfully completed sessionFactory");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
