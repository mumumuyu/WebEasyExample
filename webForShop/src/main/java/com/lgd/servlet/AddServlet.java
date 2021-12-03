package com.lgd.servlet;

import com.lgd.pojo.Book;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Asus
 */
public class AddServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		HashMap books = (HashMap) session.getAttribute("books");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		float money = (Float) session.getAttribute("money");
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		float bookprice = Float.parseFloat(price);
		book.setPrice(bookprice);
		int booknumber = Integer.parseInt(number);
		if(books.get(id)==null) {
			book.setNumber(booknumber);
			books.put(id, book);
		}else{
			Book oldbook = (Book) books.get(id);
			book.setNumber(booknumber + oldbook.getNumber());
			books.put(id, book);
		}
		money =  money + bookprice * booknumber;
		session.setAttribute("money", money);
		response.sendRedirect(request.getContextPath() + "/showCart.jsp");
	}

}
