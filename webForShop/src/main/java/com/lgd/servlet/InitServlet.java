package com.lgd.servlet;

import com.lgd.dao.BookDao;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BookDao bookDao = new BookDao();
		HashMap allbook = null;
		try {
			allbook = bookDao.getAllBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("allbook", allbook);
		response.sendRedirect(request.getContextPath()+"/showAllBook.jsp");
	}
}
