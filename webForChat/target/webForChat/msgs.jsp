<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lgd.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: LGD
  Date: 2021/11/4
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<%
    response.setHeader("Refresh","10");
%>
<table width="80%"  border="0" align="center">
    <tr bgcolor="yellow" align="center">
        <td width="75%">消息</td>
        <td width="25%">当前在线</td>
    </tr>
    <tr bgcolor="pink">
        <td><%
            ArrayList msgs = (ArrayList)application.getAttribute("msgs");
            for(int i=msgs.size()-1;i>=0;i--){
                out.println(msgs.get(i) + "<BR>");
            }
        %></td>
        <td valign="top"><%
            ArrayList users = (ArrayList)application.getAttribute("users");
            for(int i=users.size()-1;i>=0;i--){
                User user = (User)users.get(i);
                out.println(user.getId() + "(" + user.getName() + ")" + "<BR>");
            }
        %></td>
    </tr>
</table>
</body>
</html>
