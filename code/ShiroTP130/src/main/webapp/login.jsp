<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>创阳教育在线考试系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<script src="bootstrap/js/jquery-3.2.1.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
   html, body{
	   width:100%;
	   height:100%;
   }
   
   body{
	   background-size:100% 100%;
	   background-image:url(images/backgrounds/001.jpg);
	   overflow:hidden;
   }
   
   .panel{
	   width:420px;
	   height:290px;
	   margin-left:auto;
	   margin-right:auto;
	   margin-top:160px;
   }
   .panel-title{
	   height:46px;
	   line-height:46px;
	   margin:auto auto;
	   font-size:25px;
	   font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
   }
   
</style>
</head>

<body>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"><img src="images/cyedu.jpg" width="85" height="47" style="float:left"/>&nbsp;&nbsp;创阳教育在线考试系统</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form" method="post">
    <div class="form-group">
      <label for="userName" class="col-md-3 control-label">用户名</label>
      <div class="col-md-9">
        <input type='text' name="userName" id="userName" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-md-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
      <div class="col-md-9">
        <input type='password' name="password" id="password" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-md-3 control-label">类&nbsp;&nbsp;&nbsp;&nbsp;型</label>
      <div class="col-md-9">
        <select name="type" class="form-control" style="width:30%;float:left;margin-left:2px;">
          <option value="1">学员</option>
          <option value="2">管理员</option>
        </select>&nbsp;
        <input type='text' name="imageCode" id="imageCode" class="form-control" style="width:30%;float:left;margin-left:2px;">&nbsp;
        <img src="" id="imgId" class="form-control"  style="width:30%;float:left;margin-left:2px;">
      </div>
    </div>
    <div class="form-group">
       <div class="col-md-offset-3 col-md-5">
          <button type="submit" class="form-control btn btn-primary">登录</button>
       </div>

          <button type="reset" class="form-control btn btn-default" style="float:left; margin-left:-1px; width:100px">重填</button>

    </div>
    </form>
  </div>
</div>
</body>
</html>
