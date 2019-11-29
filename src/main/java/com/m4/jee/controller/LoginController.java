package com.m4.jee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.m4.jee.DAO.UserDAO;
import com.m4.jee.DAO.UserDAOImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDAO = new UserDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean result = userDAO.login(email,password);
		
		if (result) {
			
			//si result es true entonces creamos una sesion y guardamos el email en ella
			//para que en proximas peticiones sepamos que ya esta logado y redirigir a listado de usuarios
			
			HttpSession session = request.getSession();
			
			
			//guardar email
			
			session.setAttribute("email", email);
			
			//redirigir el listado de usuarios
			
			response.sendRedirect("UserController");
		}
		
		else {
			
			//si el result es false entonces no creamos sesion y redirigimos al login.jsp
			
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
