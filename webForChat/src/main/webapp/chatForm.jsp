<%@ page import="com.lgd.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/11/4
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>聊天室</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
欢迎<%=user.getName() %>聊天<BR>
<form action="${pageContext.request.contextPath}/chat.do" name="form1" method="post">
    输入聊天的消息<input name="msg" type="text" size="40">
    <input type="submit" value="发送" >
</form>
<a href="${pageContext.request.contextPath}/logout.do">退出登录</a>
<HR>
<iframe src="${pageContext.request.contextPath}/msgs.jsp" width="100%" height="80%" frameborder="0"></iframe>
</body>
</html>
