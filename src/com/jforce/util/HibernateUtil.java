package com.jforce.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jforce.dto.Candidate;
import com.jforce.dto.Voter;

public class HibernateUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = null;

	private static Session session = null;

	public HibernateUtil() {
		System.out.println("Instantiated......");
	}

	static {
		sessionFactory = new Configuration().configure().
				addAnnotatedClass(Voter.class).addAnnotatedClass(Candidate.class).
				buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
