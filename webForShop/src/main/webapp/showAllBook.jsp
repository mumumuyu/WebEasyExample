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
  	��ӭѡ��ͼ��<br>
    <%    	
    	HashMap allbook = (HashMap)session.getAttribute("allbook");
    %>
    <table border="1">
	<tr bgcolor="pink">
	<td>�鱾����</td>
	<td>�鱾�۸�</td>
	<td>����</td>
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
		<td><a href="${pageContext.request.contextPath}/buyForm.jsp?id=<%=id%>">����</a></td>
		</tr>	
	<%} %>	
	</table>
	<a href="${pageContext.request.contextPath}/showCart.jsp">�鿴���ﳵ</a>
  </body>
</html>
