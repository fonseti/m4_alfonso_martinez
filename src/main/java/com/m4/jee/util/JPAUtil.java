package com.m4.jee.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility Class for manage JPA connections
 * @author alfonso.martinez
 */
public class JPAUtil {

	private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("m4_alfonso_martinez");
	

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

}
