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
  	欢迎选购图书<br>
    <%    	
    	HashMap allbook = (HashMap)session.getAttribute("allbook");
    %>
    <table border="1">
	<tr bgcolor="pink">
	<td>书本名称</td>
	<td>书本价格</td>
	<td>购买</td>
	</tr>
	<%
		Set set = allbook.keySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			String id = (String)ite.next();
			Book book = (Book)allbook.get(id);
	%>
		<tr bgcolor="yellow">
		<td><%=book.getName()%></td>
		<td><%=book.getPrice()%></td>
		<td><a href="${pageContext.request.contextPath}/buyForm.jsp?id=<%=id%>">购买</a></td>
		</tr>	
	<%} %>	
	</table>
	<a href="${pageContext.request.contextPath}/showCart.jsp">查看购物车</a>
  </body>
</html>
