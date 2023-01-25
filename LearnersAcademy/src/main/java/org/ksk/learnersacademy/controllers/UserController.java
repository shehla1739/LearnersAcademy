package org.ksk.learnersacademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ksk.learnersacademy.Service.UserService;
import org.ksk.learnersacademy.Service.UserServiceImpl;
import org.ksk.learnersacademy.entities.User;

@WebServlet("/register")
public class UserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		resp.setContentType("text/html");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String usertype=req.getParameter("usertype");
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserType(usertype);
		userService.insert(user);
		req.setAttribute("msg","User registered Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp"); 
		rd.forward(req, resp);
		
		
	}
}
