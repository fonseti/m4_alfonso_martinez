package com.m4.jee.DAO;

import java.util.List;

import com.m4.jee.entities.User;
import com.m4.jee.DAO.UserDAO;

public interface UserDAO {
	/**
	 * Recibe como parámetro el string login y el string password y ejecuta
	 * una query contra la base de datos verificando si hay algún usuario con esos
	 * datos. Si lo hay devuelve true, si no false.
	 * @param login
	 * @param password
	 * @return true o false si existe el usuario
	 */
	public boolean login(String email, String password);
	
	/**
	 * recibe un id, busca y devuelve el usuario por ese id
	 * @param id
	 * @return un usuario
	 */
	public User findById(Long id);
	
	/**
	 * recibe un id, busca y devuelve el usuario por email
	 * @param email
	 * @return un usuario
	 */
	public User findByEmail(String email);
	
	/**
	 * no recibe parametros, devuelve una lista de todos los usuarios de la base de datos
	 * @return lista de usuarios
	 */
	public List<User> findAll();
	
	/**
	 * Recibe un objeto usuario y lo almacena en la base de datos
	 * @param usuario
	 * @return
	 */
	public boolean create(User usuario);
	
	/**
	 * recibe un objeto usuario y lo actualiza en la base de datos
	 * @param usuario
	 * @return
	 */
	public boolean  update(User usuario);
	
	
	/**
	 * Recibe un id y borra el usuario de la base de datos correspondiente a ese id
	 * @param i
	 * @return 
	 */
	public boolean delete(Long id);


}
