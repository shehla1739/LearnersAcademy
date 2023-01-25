package org.ksk.learnersacademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ksk.learnersacademy.Service.UserService;
import org.ksk.learnersacademy.Service.UserServiceImpl;
import org.ksk.learnersacademy.entities.User;
@WebServlet("/login")
public class LoginController extends HttpServlet{
	private UserService userService=new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=userService.get(username, password);
		
		if(user!=null && user.getUserType().equals("admin")) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("msg","Username or password is invalid, Please try again ");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
