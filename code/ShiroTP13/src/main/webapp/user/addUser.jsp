<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html><!-- InstanceBegin template="/Templates/main.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- InstanceBeginEditable name="doctitle" -->
<title>创阳教育在线考试系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css">
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
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
      <img src="../images/cyedu.jpg" width="132" height="50" class=" img-rounded"/>
   </div>
   <span data-toggle="collapse" href="#leftNav" class="navbar-brand glyphicon glyphicon-align-justify" style="margin-left:20px;"></span>
   
   <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><img src="../images/icos/menu_account.png" class="img-circle"/>admin(管理员)</a></li><li><a>|</a></li>
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
                   <a data-toggle="collapse" data-parent="#accodion" href="#questionBankCollapse"><img src="../images/icos/menu_qdb.png" class="img-rounded"/>&nbsp;&nbsp;题库管理</a>
                 </h4>
              </div>
              
              <div id="questionBankCollapse" class=" panel-collapse collapse in">
                   <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="../questionBank/addQuestionBank.html">新增题库</a></li>
                    <li><a href="../questionBank/questionBankList.html">题库列表</a></li>
                    <li><a href="../questionBank/addQuestion_1.html">新增试题</a></li>
                    <li><a href="../questionBank/importQuestions.html">导入试题</a></li>
                    <li><a href="../questionBank/questionList.html">管理试题</a></li>
                  </ul>
              </div>
           </div>
           
           <!--试题管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accodion" href="#examPaperCollapse"><img src="../images/icos/menu_paper.png" class="img-rounded"/>&nbsp;&nbsp;试卷管理</a>
                </h4>
              </div>
              
              <div id="examPaperCollapse" class="panel-collapse collapse in">
                 <ul class=" panel-body nav nav-pills nav-stacked">
                   <li><a href="../examPaper/examPaperTypeList.html">分类管理</a></li>
                   <li><a href="../examPaper/createExamPaper.html">创建试卷</a></li>
                   <li><a href="../examPaper/examPaperList.html">试卷管理</a></li>
                 </ul>
              </div>           
           </div>
           
           <!--在线学习-->
           <div class="panel panel-default">
              <div class="panel-heading">
                 <h4 class="panel-title">
                   <a data-toggle="collapse" data-parent="#accodion" href="#onlineLearnCollapse"><img src="../images/icos/menu_learn.png" class="img-rounded"/>&nbsp;&nbsp;在线学习</a>
                 </h4>
              </div>
              <div id="onlineLearnCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                   <li><a href="../online/courseTypeList.html">分类管理</a></li>
                   <li><a href="../online/courseList.html">课程管理</a></li>
                 </ul>
              </div>
           </div>
           
           <!--用户管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#userCollapse"><img src="../images/icos/menu_users.png" class="img-rounded"/>&nbsp;&nbsp;用户管理</a>
                  </h4>
              </div>
              <div id="userCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="deptList.html">管理部门</a></li>
                    <li><a href="classList.html">管理班级</a></li>
                    <li><a href="roleList.html">管理角色</a></li>
                    <li><a href="userList.html">管理用户</a></li>
                 </ul>
              </div>
           </div>
           
           <!--互动交流-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#commuCollapse"><img src="../images/icos/menu_interaction.png" class="img-rounded"/>&nbsp;&nbsp;系统信息</a>
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
                    <a data-toggle="collapse" data-parent="#accodion" href="#analysisCollapse"><img src="../images/icos/menu_analysis.png" class="img-rounded"/>&nbsp;&nbsp;统计分析</a>
                  </h4>
              </div>
             <div id="analysisCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="../analysis/paperAnalysisList.html">试卷分析</a></li>
                    <li><a href="../analysis/examAnalysis.html">考试分析</a></li>
                    <li><a href="../analysis/scoreAnalysis.html">成绩分析</a></li>
                 </ul>
              </div>
           </div>
           <!--权限管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#permissionCollapse"><img src="../images/icos/perms.jpg" width="22" height="24" class="img-rounded"/>&nbsp;&nbsp;权限管理</a>
                  </h4>
              </div>
              <div id="permissionCollapse" class="panel-collapse collapse in">
                 <ul class="panel-body nav nav-pills nav-stacked">
                    <li><a href="../permission/resourceList.html">资源管理</a></li>
                    <li><a href="../permission/roleList.html">角色管理</a></li>
                    <li><a href="userList.html">分配角色</a></li>
                    <li><a href="userList.html">分配权限</a></li>
                 </ul>
              </div>
           </div>
           <!--系统管理-->
           <div class="panel panel-default">
              <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accodion" href="#systemCollapse"><img src="../images/icos/system.png" class="img-rounded"/>&nbsp;&nbsp;系统管理</a>
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
        <li><a href="#"><!-- InstanceBeginEditable name="EditRegion4" -->用户管理<!-- InstanceEndEditable --></a></li>
        <li><a href="#"><!-- InstanceBeginEditable name="EditRegion5" -->添加用户<!-- InstanceEndEditable --></a></li>
     </ol>
	 <!-- InstanceBeginEditable name="EditRegion3" -->
     
     <div class="row navbar">
       <button class=" navbar-btn btn-primary" onClick="location.href='addUser.html'">新增用户</button>
       <button class=" navbar-btn" onclick="location.href='importUsers.html'">导入用户</button>
       <button class=" navbar-btn" onclick="location.href='userList.html'">用户列表</button>
       
     </div>
     
     <script type="text/javascript">
         function toSubmit(){
        	 // user.urUserName=zhangsan&user.urPassword=12345
        	 var _data = $("#addUserForm").serialize();
        	 $.ajax({
        		 type:'post',
        		 url:'../userAction!add.action',
        		 data:_data,
        		 success:function(json){
        			 alert(json.message);
        		 }
        	 });
         }
     </script>
     <div class="row">
      <form id="addUserForm" action="#" method="post">
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">用户名</label>
           <div class="col-sm-8">
             <input type="text" name="user.urUserName" id="userName" class="form-control"/>
           </div>
        </div>
       </div>
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
           <div class="col-sm-8">
             <input type="password" name="user.urPassword" id="password" class="form-control"/>
           </div>
        </div>
       </div>
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">所属部门</label>
           <div class="col-sm-8">
             <select id="dept" name="dept" class="form-control">
                <option value="-1">全部</option>
                <optgroup label="员工">
                  <option value="1">开发部</option>
                  <option value="2">市场部</option>
                </optgroup>
                <optgroup label="学员">
                  <option value="1">TP1701</option>
                  <option value="1">TP1702</option>
                </optgroup>
             </select>
           </div>
        </div>
       </div>
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">姓名</label>
           <div class="col-sm-8">
             <input type="text" name="name" id="name" class="form-control"/>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">编号</label>
           <div class="col-sm-8">
             <input type="text" name="code" id="code" class="form-control"/>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">电话</label>
           <div class="col-sm-8">
             <input type="text" name="phone" id="phone" class="form-control"/>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">邮箱</label>
           <div class="col-sm-8">
             <input type="text" name="email" id="email" class="form-control"/>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">状态</label>
           <div class="col-sm-8">
             <select id="status" name="status" class="form-control">
                <option value="1">待审核</option>
                <option value="2">正常</option>
                <option value="3">锁定</option>
             </select>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           <label class="control-label col-sm-2 text-right">备注</label>
           <div class="col-sm-8">
             <textarea name="remark" id="remark" class="form-control" rows="4"></textarea>
           </div>
        </div>
       </div>
       
       <div class="row">
        <div class="form-group">
           
           <div class="col-sm-8 col-sm-offset-2">
             <input type="button" class="btn btn-primary" onclick="toSubmit()" value="提交"/>
             <input type="reset" class="btn" value="重写"/>
           </div>
        </div>
       </div>
      </form>
     </div>
     <!-- InstanceEndEditable -->
     </div>
  </div>
</div>
</body>
<!-- InstanceEnd --></html>
