<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/13/2023
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <%@include file="/common.jsp"%>
</head>

<body>
<div id="body">
  <ol class="breadcrumb">
    <li class="active"><a href="#">系统</a></li>
    <li>修改员工</li>
  </ol>

  <div class="tabli">
    <span>基本信息</span>
  </div>
<form action="empServlet" method="post">
  <input type="hidden" name="pageNo" value="${param.pageNo}">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="empno" value="${requestScope.emp.empno}"/>
  <div class="tabbody">
    <div class="bodyli active">

      <!-- ///// -->
      <div class="inputbox">
        <span class="title">员工编号</span>
        <div class="inputright">
          <input type="text" name="empno" class="form-control input-sm" value="${requestScope.emp.empno}"/>
        </div>
      </div>
      <!-- ///// -->
      <div class="inputbox">
        <span class="title">员工姓名</span>
        <div class="inputright">
          <input type="text" name="ename" class="form-control input-sm" value="${requestScope.emp.ename}" />
        </div>
      </div>
      <!-- ///// -->
      <div class="inputbox">
        <span class="title">员工职位</span>
        <div class="inputright">
          <input type="text" name="job" class="form-control input-sm" value="${requestScope.emp.job}" />
        </div>
      </div>
      <!-- ///// -->
      <div class="inputbox">
        <span class="title">经理编号</span>
        <div class="inputright">
          <input type="text" name="mgr" class="form-control input-sm" value="${requestScope.emp.mgr}" />
        </div>
      </div>
      <!-- ///// -->

      <div class="inputbox">
        <span class="title">入职日期</span>
        <div class="inputright">
          <input type="text" id="date" placeholder="请选择时间"
                 name="hiredate" class="form-control br0 cursorpointer" value="${requestScope.emp.hiredate}" readonly>
          <span class="btn btn-default"><i class="fa fa-calendar"></i></span>
        </div>
      </div>
          <!-- ///// -->
      <div class="inputbox">
        <span class="title">员工薪资</span>
        <div class="inputright">
          <input type="text" name="sal" class="form-control input-sm" value="${requestScope.emp.sal}" />
        </div>
      </div>
        <!-- ///// -->
      <div class="inputbox">
        <span class="title">员工奖金</span>
        <div class="inputright">
          <input type="text" name="comm" class="form-control input-sm" value="${requestScope.emp.comm}" />
        </div>
      </div>
      <!-- ///// -->
      <div class="inputbox">
        <span class="title">部门编号</span>
        <div class="inputright">
          <input type="text" name="deptno" class="form-control input-sm" value="${requestScope.emp.deptno}" />
        </div>
      </div>

    </div>
  </div>

  <div class="tbfooter">
    <button class="btn btn-success"><i class="fa fa-floppy-o"></i>修改员工</button>
  </div>
</form>
</div>
</body>
</html>

<script>
  // 2、创建日期
  laydate.render({
    elem: '#date',
    theme:"#5cb85c",
    format: 'yyyy-MM-dd', //指定时间格式
    // value: new Date(), // 创建日期默认为当天
  });
</script>
