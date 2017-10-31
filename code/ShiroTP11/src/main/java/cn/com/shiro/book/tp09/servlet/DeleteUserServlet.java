package cn.com.shiro.book.tp09.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/user/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String currUser = (String)SecurityUtils.getSubject().getPrincipal();
		PrintWriter out = response.getWriter();
		out.print(currUser + " 你好，欢迎访问DeleteUserServlet，TKS!<br/>");
		out.print("<a href='../welcome.jsp'>点击这里</a>返回到导航页面");
		out.flush();
		out.close();
	}

}
