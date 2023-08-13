<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/13/2023
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!-- /* // ****后台页面定制，设计QQ：951252660 */ -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <%@include file="/common.jsp"%>
</head>

<body>
<div id="login">
    <form action="userServlet" method="post">
        <input type="hidden" name="action" value="login">
        <div class="center">
            <dl>
                <dt><i class="gi gi-leaf"></i>Leaf · <span> Cms</span></dt>
                <dd><span><i class="fa fa-fw fa-user"></i></span><input type="text" name="username" placeholder="请输入账号"></dd>
                <dd><span><i class="fa fa-fw fa-lock"></i></span><input type="password" name="password" placeholder="请输入密码"></dd>
                <dd><button>登录</button></dd>
            </dl>
        </div>
    </form>
</div>
</body>

</html>
