package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Assign;
import entity.Classes;
import entity.Students;
import entity.Subjects;
import entity.Teachers;

public class HibernateUtil {
	
	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory != null)
			return sessionFactory;

		// STEP 1: Creating Configuration object and providing DB inforamation and
		// mapping information
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Students.class);
		configuration.addAnnotatedClass(Classes.class);
		configuration.addAnnotatedClass(Teachers.class);
		configuration.addAnnotatedClass(Assign.class);
		configuration.addAnnotatedClass(Subjects.class);



		// STEP 2: create Session Factory object and return
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}

}