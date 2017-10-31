<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <shiro:principal/>你好，恭喜成功进入本系统！<br>
   您可以进行如下操作，请点击它们进入对应操作页面  <a href="logout">退出点这里</a> &nbsp;&nbsp;<a href="adminManager.jsp">点这里进入管理员界面</a><br/>
   <a href="demo/userAction!add.action">添加用户</a><br/>
   <a href="demo/userAction!edit.action">修改用户</a><br/>
   <a href="demo/userAction!delete.action">删除用户</a><br/>
   <a href="demo/userAction!query.action">查询用户</a><br/>
   <br/>
   <a href="demo/orderAction!add.action">添加订单</a><br/>
   <a href="demo/orderAction!edit.action">修改订单</a><br/>
   <a href="demo/orderAction!delete.action">删除订单</a><br/>
   <a href="demo/orderAction!query.action">查询订单</a><br/>
</body>
</html>