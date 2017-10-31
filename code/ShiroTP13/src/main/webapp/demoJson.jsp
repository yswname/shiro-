<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="bootstrap/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	    function toSubmit(){
	    	/*var jsonObj = [{"roleList.rlName":"zhangsan1","roleList.rlRemark":"zhangsanRemark1"},
	    	               {"roleList.rlName":"zhangsan2","roleList.rlRemark":"zhangsanRemark2"},
	    	               {"roleList.rlName":"zhangsan3","roleList.rlRemark":"zhangsanRemark3"}];
	    	var _data = JSON.stringify(jsonObj);
	    	*/
	    	var jsonObj = [{"rlName":"zhangsan1","rlRemark":"zhangsanRemark1"},
	    	               {"rlName":"zhangsan2","rlRemark":"zhangsanRemark2"},
	    	               {"rlName":"zhangsan3","rlRemark":"zhangsanRemark3"}];
	    	var _data = "myData=" + JSON.stringify(jsonObj);
	    	
	    	alert(_data);
	    	$.ajax({
	    		type:'post',
	    		
	    		url:'roleAction!demoJson.action',
	    		data:_data,
	    	
	    		success:function(msg){
	    			alert(msg);
	    		}
	    	});
	    }
	</script>
  </head>
  
  <body>
    <input type="button" value="test" onclick="toSubmit()"/>
  </body>
</html>
