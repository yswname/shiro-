<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html><!-- InstanceBegin template="/Templates/main.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- InstanceBeginEditable name="doctitle" -->
<title>创阳教育在线考试系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<script src="bootstrap/js/jquery-3.2.1.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->

<style type="text/css">
   body{
	   min-width:1024px;
   }
</style>
</head>

<body>

<div class="container-fluid">
   <nav class="navbar navbar-default navbar-fixed-top bg-primary col-md-12  col-sm-12 col-xs-12"  role="banner">
   <div class="navbar-header" style="margin-left:20px;">
      <img src="images/cyedu.jpg" width="132" height="50" class=" img-rounded"/>
   </div>
   <span data-toggle="collapse" href="#leftNav" class="navbar-brand glyphicon glyphicon-align-justify" style="margin-left:20px;"></span>
   
   <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><img src="images/icos/menu_account.png" class="img-circle"/>admin(管理员)</a></li><li><a>|</a></li>
     <li><a href="#">账号</a></li><li><a>|</a></li>
     <li><a href="#">反馈问题</a></li><li><a>|</a></li>
     <li style="margin-right:20px;"><a href="#">退出</a></li>
   </ul>
  </nav>
  
  <div class="row " style="margin-top:55px;">
     <!--左边折叠式导航-->
     <div id="leftNav"  class="col-sm-2 col-md-2  col-sm-2 col-xs-2 collapse in">
        <div class="panel-group" id="accodion">
           <!--题库管理-->
          <div class="panel panel-default">
              <div class="panel-heading">
                 <h4 class="panel-title">
                   <a data-toggle="collapse" data-parent="#accodion" href="#questionBankCollapse"><img src="images/icos/menu_qdb.png" class="img-rounded"/>&nbsp;&nbsp;题库管理</a>
                 </h4>
              </div>
              
              <div id="questionBankCollapse" class=" panel-collapse collapse in">
                   <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="questionBank/addQuestionBank.html">新增题库</a></li>
                    <li><a href="questionBank/questionBankList.html">题库列表</a></li>
                    <li><a href="questionBank/addQuestion_1.html">新增试题</a></li>
                    <li><a href="questionBank/importQuestions.html">导入试题</a></li>
                    <li><a href="questionBank/questionList.html">管理试题</a></li>
                  </ul>
              </div>
           </div>
           
           <!--试题管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accodion" href="#examPaperCollapse"><img src="images/icos/menu_paper.png" class="img-rounded"/>&nbsp;&nbsp;试卷管理</a>
                </h4>
              </div>
              
              <div id="examPaperCollapse" class="panel-collapse collapse in">
                 <ul class=" panel-body nav nav-pills nav-stacked">
                   <li><a href="examPaper/examPaperTypeList.html">分类管理</a></li>
                   <li><a href="examPaper/createExamPaper.html">创建试卷</a></li>
                   <li><a href="examPaper/examPaperList.html">试卷管理</a></li>
                 </ul>
              </div>           
           </div>
           
           <!--在线学习-->
           <div class="panel panel-default">
              <div class="panel-heading">
                 <h4 class="panel-title">
                   <a data-toggle="collapse" data-parent="#accodion" href="#onlineLearnCollapse"><img src="images/icos/menu_learn.png" class="img-rounded"/>&nbsp;&nbsp;在线学习</a>
                 </h4>
              </div>
              <div id="onlineLearnCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                   <li><a href="online/courseTypeList.html">分类管理</a></li>
                   <li><a href="online/courseList.html">课程管理</a></li>
                 </ul>
              </div>
           </div>
           
           <!--用户管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#userCollapse"><img src="images/icos/menu_users.png" class="img-rounded"/>&nbsp;&nbsp;用户管理</a>
                  </h4>
              </div>
              <div id="userCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="user/deptList.html">管理部门</a></li>
                    <li><a href="user/classList.html">管理班级</a></li>
                    <li><a href="user/roleList.html">管理角色</a></li>
                    <li><a href="user/userList.html">管理用户</a></li>
                 </ul>
              </div>
           </div>
           
           <!--互动交流-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#commuCollapse"><img src="images/icos/menu_interaction.png" class="img-rounded"/>&nbsp;&nbsp;系统信息</a>
                  </h4>
              </div>
             <div id="commuCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="#">分类管理</a></li>
                    <li><a href="#">公告管理</a></li>
                 </ul>
              </div>
           </div>
           
           <!--统计分析-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#analysisCollapse"><img src="images/icos/menu_analysis.png" class="img-rounded"/>&nbsp;&nbsp;统计分析</a>
                  </h4>
              </div>
             <div id="analysisCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="analysis/paperAnalysisList.html">试卷分析</a></li>
                    <li><a href="analysis/examAnalysis.html">考试分析</a></li>
                    <li><a href="analysis/scoreAnalysis.html">成绩分析</a></li>
                 </ul>
              </div>
           </div>
           <!--权限管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#permissionCollapse"><img src="images/icos/perms.jpg" width="22" height="24" class="img-rounded"/>&nbsp;&nbsp;权限管理</a>
                  </h4>
              </div>
              <div id="permissionCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="resourceList.html">资源管理</a></li>
                    <li><a href="roleList.html">角色管理</a></li>
                    <li><a href="user/userList.html">分配角色</a></li>
                    <li><a href="user/userList.html">分配权限</a></li>
                 </ul>
              </div>
           </div>
           <!--系统管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#systemCollapse"><img src="images/icos/system.png" class="img-rounded"/>&nbsp;&nbsp;系统管理</a>
                  </h4>
              </div>
              <div id="systemCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="#">角色管理</a></li>
                    <li><a href="#">系统设置</a></li>
                    <li><a href="#">系统日志</a></li>
                    <li><a href="#">关于软件</a></li>
                 </ul>
              </div>
           </div>
        </div>
     </div>
     
     
     
     <div class="col-sm-10  col-md-10  col-sm-10 col-xs-10">
     
     <ol class="row breadcrumb">
        <li><a href="#">首页</a></li>
        <li><a href="#"><!-- InstanceBeginEditable name="EditRegion4" -->权限管理<!-- InstanceEndEditable --></a></li>
        <li><a href="#"><!-- InstanceBeginEditable name="EditRegion5" -->资源列表<!-- InstanceEndEditable --></a></li>
     </ol>
	 <!-- InstanceBeginEditable name="EditRegion3" -->
     
     <div class="row navbar">
       <button class=" navbar-btn" onClick="location.href='resourceAction!initAdd.action'">新增资源</button>
       <button class=" navbar-btn  btn-primary" onclick="location.href='resourceAction!findAll.action'">资源列表</button>
       
     </div>
     
     
     <div class="row">
       <div class="table-responsive">
        <table class="table table-hover">
          <caption>资源列表</caption>
          <thead>
             <tr>
                <th>序号</th>
                <th>资源名称</th>
                <th>包含资源项</th>
             </tr>
          </thead>
          <tbody>
          
            <c:forEach items="${resourceList }" var="_resource" varStatus="_index">
             <tr>
                <td>${_index.index+1 }</td>
                <td><a href="resourceAction!view.action?resource.rscId=${_resource.rscId }">${_resource.rscName }</a></td>
                <td>
                   <table class="table table-hover">
                      <tbody>
                         
                         <c:forEach items="${_resource.shrResourceItems }" var="_item">
                         <tr>
                            <td>${_item.itmType }</td>
                            <td>${_item.itmUrl }</td>
                         </tr>
                         </c:forEach>
                         
                      </tbody>
                   </table>
                </td>
             </tr>
             </c:forEach>
             
             
             
          </tbody>
        </table>
       </div>
     </div>
     
     <!-- InstanceEndEditable -->
     </div>
  </div>
</div>
</body>
<!-- InstanceEnd --></html>
