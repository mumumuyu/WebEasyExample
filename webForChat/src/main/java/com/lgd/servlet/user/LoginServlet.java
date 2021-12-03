package com.lgd.servlet.user;

import com.lgd.pojo.User;
import com.lgd.service.UserService;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Asus
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	//�����û�����������ҵ��㡢ת����ͼ
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = this.getServletConfig().getServletContext();

		String msg = null;
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		UserService userService = new UserService();
		User user = userService.login(id,pwd);
		PrintWriter out = resp.getWriter();
		if(null != user){
			System.out.println("succeed ============ " );
			req.getSession().setAttribute("user",user);
			ArrayList users = (ArrayList) application.getAttribute("users");
			ArrayList msgs = (ArrayList) application.getAttribute("msgs");
			users.add(user);
			Date day = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			msgs.add(df.format(day)+ ": " + user.getName()+ " 上线啦");
			msg="ok";
		}else {
			System.out.println("失败 ============ ");
			msg="no";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", msg);
		resp.getWriter().write(jsonObject.toString());
	}
}
