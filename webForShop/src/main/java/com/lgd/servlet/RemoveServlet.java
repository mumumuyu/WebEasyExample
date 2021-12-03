package com.lgd.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lgd.pojo.Book;

/**
 * @author lgd
 */
public class RemoveServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		HashMap books = (HashMap)session.getAttribute("books");
		Book book = (Book)books.get(id);
		float money = (Float)session.getAttribute("money");
		money = money - book.getNumber()*book.getPrice();
		session.setAttribute("money", money);
		books.remove(id);
		response.sendRedirect(request.getContextPath()+"/showCart.jsp");
	}
}
