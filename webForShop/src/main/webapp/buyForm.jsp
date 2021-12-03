<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="com.lgd.pojo.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/10/13
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <body> 
    <%
		String id = request.getParameter("id");
    	HashMap allbook = (HashMap)session.getAttribute("allbook");
    	Book book = (Book)allbook.get(id);
    %>
    欢迎购买：<%=book.getName()%>
    <form action="${pageContext.request.contextPath}/servlet/AddServlet" method="post">
		书本价格:<%=book.getPrice()%><BR>
		<input name="id" type="hidden" value="<%=book.getId()%>">
		<input name="name" type="hidden" value="<%=book.getName()%>">
		<input name="price" type="hidden" value="<%=book.getPrice()%>">
		数量:<input name="number" type="text">
		<input type="submit" value="购买">
    </form>    
  </body>
</html>
