package com.m4.jee.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m4.jee.DAO.UserDAO;
import com.m4.jee.DAO.UserDAOImpl;
import com.m4.jee.entities.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	UserDAO userDAO = new UserDAOImpl();
	
	public UserController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listUser(request, response);
				break;
				
			case "EDIT":
				getSingleUser(request, response);
				break;
				
			case "DELETE":
				deleteUser(request, response);
				break;
				
			default:
				listUser(request, response);
				break;
				
		}
		
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(userDAO.delete(Long.valueOf(id))) {
			request.setAttribute("NOTIFICATION", "User Deleted Successfully!");
		}
		
		listUser(request, response);
	}

	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		User theuser = userDAO.findById(Long.valueOf(id));
		
		request.setAttribute("user", theuser);
		
		dispatcher = request.getRequestDispatcher("/views/user-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> theList = userDAO.findAll();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/user-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setAge(request.getParameter("age"));
		
		if(id.isEmpty() || id == null) {
			// crea un usuario
			if(userDAO.create(user)){
				request.setAttribute("NOTIFICATION", "User Saved Successfully!");
			}
		
		}else {
			// actuasliza
			user.setId(Long.valueOf(id));
			if(userDAO.update(user)) {
				request.setAttribute("NOTIFICATION", "User Updated Successfully!");
			}
			
		}
		
		listUser(request, response);
	}

	

}
