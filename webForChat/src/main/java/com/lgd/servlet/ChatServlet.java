package com.lgd.servlet;

import com.lgd.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = this.getServletConfig().getServletContext();
        User user = (User)req.getSession().getAttribute("user");
        String msg = req.getParameter("msg");
        ArrayList msgs = (ArrayList)application.getAttribute("msgs");
        if(msg!=null && !msg.equals("")){
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            msgs.add(df.format(day)+ "  " + user.getName() + ": " + msg);
        }
        resp.sendRedirect(req.getContextPath()+"/chatForm.jsp");
    }
}
