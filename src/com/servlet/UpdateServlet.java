package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String position = request.getParameter("position");
		String salary_str = request.getParameter("salary");
		double salary = Double.parseDouble(salary_str);
		String home = request.getParameter("home");
		String info = request.getParameter("info");

		System.out.println("------------------------------------" + userId);

		UserDao ud = new UserDaoImpl();

		if (ud.update_em(userId, name, pwd, sex, position,salary,home, info)) {
			request.setAttribute("msg", "更新成功");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
	}
}
