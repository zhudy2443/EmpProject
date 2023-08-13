<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/13/2023
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<!--写 base 标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">


<link rel="stylesheet" href="component/style/components.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/themes.css">
<script src="component/js/JQuery2.1.4.js"></script>
<script src="component/plugins/layer/layer.js"></script>
<script src="./component/js/bootstrap.min.js"></script>
<script src="./component/plugins/laydate/laydate.js"></script>
<script src="js/vendor/modernizr-respond.min.js"></script>