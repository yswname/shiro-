package cn.com.shiro.book.tp09.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
//		try{
//			SecurityUtils.getSubject().login(token);
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
//		}catch(Exception e){
			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}
	}

}
