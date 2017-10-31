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
   <!-- 获取subject的身份标识 -->
   <shiro:principal/>你好，恭喜成功进入本系统！<br>
   您可以进行如下操作，请点击它们进入对应操作页面  <a href="logout">退出点这里</a><br/>
   <a href="admin/adminServlet">进入AdminServlet页面</a><br/>
   <br/>
   <a href="user/createUserServlet">进入CreateUserServlet页面</a><br/>
   <a href="user/updateUserServlet">进入UpdateUserServlet页面</a><br/>
   <a href="user/deleteUserServlet">进入DeleteUserServlet页面</a><br/>
   <a href="user/queryUserServlet">进入QueryUserServlet页面</a><br/>
   测试Shiro标签<br/>
   <!-- 判断是否登录，登录了，就显示中间的内容 -->
   <shiro:authenticated>
      <a href="logout">点击我退出</a>
   </shiro:authenticated>
   <shiro:notAuthenticated>
      <a href="index.jsp">点击我进入登录页面</a>
   </shiro:notAuthenticated>
   
   <br/>
   <shiro:guest>匿名用户可以看到的内容</shiro:guest>
   <br/>
   
   <shiro:hasAnyRoles name="role1,admin">
      只用当前的Subject拥有name中指定的任何一个角色，都可以显示
   </shiro:hasAnyRoles>
   
   <shiro:lacksRole name="admin,role2">
      只要有一个角色没有，可见
   </shiro:lacksRole>
   
   <shiro:user>
      只要登录了，就可见
   </shiro:user>
</body>
</html>