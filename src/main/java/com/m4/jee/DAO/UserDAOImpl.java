package com.m4.jee.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.m4.jee.entities.User;
import com.m4.jee.util.JPAUtil;



/**
 * 
 * 
 * 
 * 1. view --> JSP / JSTL -- interfaz de usuario
 * 2. controller --> Servlet REdirecciona, obtiene datos, carga las vistas etc
 * 3. Service --> llama al DAO y y hace operaciones (logica de negocio)
 * 4. DAO o Repository --> operaciones contra base datos: CRUD
 * 
 * 
 * 
 * @author alfonso.martinez
 *
 */
public class UserDAOImpl implements UserDAO {
	
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("m4_alfonso_martinez");
			
	EntityManager manager;
//	private static final String USER_COUNT ="SELECT COUNT (u) from User u "
//			+ "WHERE u.email= :email AND u.password= :password";
	
	private static final String FIND_BY_EMAIL = "SELECT u FROM User u "
			+ "WHERE u.email = :email ";
	
//	EntityManager manager;
	
	public void closeEntityManager() {
		manager.close();
	}
	
	public void openEntityManager() {
		manager = JPAUtil.getEntityManager();
	}
	


	
	@Override
	public boolean delete(Long id) {
		boolean flag = false;
		try {
			manager = emFactory.createEntityManager();
			manager.getTransaction().begin();   
			User user = manager.find(User.class, id);
			if (user != null) {
				manager.remove(user);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public boolean login(String email, String password) {
		openEntityManager();
//		TypedQuery<Long> query = manager.createQuery(USER_COUNT, Long.class);
//		query.setParameter("email", email);
//		query.setParameter("password", password);
//		Long numUsuario = query.getSingleResult();
//		boolean result = numUsuario > 0;
		closeEntityManager();
		return true;
	}


	@Override
	public User findById(Long id) {
		User user = null;
		try {
			manager = emFactory.createEntityManager();
			user = manager.find(User.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = manager.createQuery(FIND_BY_EMAIL, User.class);
		query.setParameter("email", email);
		User numUsuario = query.getSingleResult();
		return numUsuario;
	}

	@Override
	public List<User> findAll() {
		try {
			manager = emFactory.createEntityManager();
			TypedQuery<User> namedQuery = manager.createNamedQuery("User.findAll", User.class);
			List<User> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	@Override
	public boolean create(User usuario) {
		boolean flag = false;
		try {
			manager = emFactory.createEntityManager();
			manager.getTransaction().begin();   
			manager.persist(usuario); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(User usuario) {
		boolean flag = false;
		try {
			manager = emFactory.createEntityManager();
			manager.getTransaction().begin();   
			manager.merge(usuario); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
