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
  <table border="1">
	<tr bgcolor="pink">
	<td>�鱾����</td>
	<td>�鱾�۸�</td>
	<td>����</td>
	<td>ɾ��</td>
	</tr>
   <%
   		HashMap books = (HashMap)session.getAttribute("books");		
		Set set = books.keySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			String bookno = (String)ite.next();
			Book book = (Book)books.get(bookno);
	%>
	<tr bgcolor="yellow">
		<td><%=book.getName()%></td>
		<td><%=book.getPrice()%></td>
		<td><%=book.getNumber()%></td>
		<td><a href="${pageContext.request.contextPath}/servlet/RemoveServlet?id=<%=book.getId()%>">ɾ��</a></td>
		</tr>
	<%
		}			
   %>
   </table>
   �ֽ��ܶ�:<%=session.getAttribute("money")%><HR>
   <a href="${pageContext.request.contextPath}/showAllBook.jsp">��������</a>
  </body>
</html>
