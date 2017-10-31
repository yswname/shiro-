<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <shiro:principal/>你好，恭喜成功进入本系统！<br>
   您可以进行如下操作，请点击它们进入对应操作页面  <a href="logout">退出点这里</a><br/>
   <a href="admin/adminServlet">进入AdminServlet页面</a><br/>
   <br/>
   <a href="user/createUserServlet">进入CreateUserServlet页面</a><br/>
   <a href="user/updateUserServlet">进入UpdateUserServlet页面</a><br/>
   <a href="user/deleteUserServlet">进入DeleteUserServlet页面</a><br/>
   <a href="user/queryUserServlet">进入QueryUserServlet页面</a><br/>
</body>
</html>