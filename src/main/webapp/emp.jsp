<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/13/2023
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
  $(function (){
    $("#searchPageBtn").click(function (){
      var pageNo=$("#pn_input").val();
      location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
    });
    // 给删除的 a 标签绑定单击事件，用于删除的确认提示操作
    $("a.deleteClass").click(function () {
      // 在事件的 function 函数中，有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象。
      /*
       *  confirm 是确认提示框函数
       * 参数是它的提示内容 * 它有两个按钮，一个确认，一个是取消。
       * 返回 true 表示点击了，确认，返回 false 表示点击取消。
       */
      return confirm("你确定要删除【"+$(this).parent().parent().parent().find("td:first").text()+"】?");
      // return false// 阻止元素的默认行为===不提交请求
    });
  });
</script>

<body>
<div id="body">
  <ol class="breadcrumb">
    <li class="active"><a href="#">系统</a></li>
    <li>员工列表</li>
  </ol>

  <div class="barboxs">
    <button
            class="btn btn-success pull-left "
            data-toggle="modal" data-target="#myModal"
            title="添加员工"
            data-placement="right"
            data-original-title="添加员工">
      <i class="fa fa-pencil-square-o"></i>
    </button>

    <div class="leftbox">

      <div class="ml10">
        <div class="input-group date input-datepicker mtb0">
          <input type="text" id="date" placeholder="请选择入职时间段"
                 name="date" class="form-control cursorpointer" readonly="readonly">
          <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
        </div>
      </div>

      <div class="liselect">
        <div class="input-group">
          <input type="text" class="form-control example-typeahead"
                 placeholder="请输入最小工资">
        </div>
      </div>

      <div class="liselect">
        <div class="input-group">
          <input type="text" class="form-control example-typeahead"
                 placeholder="请输入最大工资">
        </div>
      </div>

      <div class="liselect">
        <div class="input-group">
          <input type="text" class="form-control example-typeahead"
                 placeholder="请输入员工职位">
        </div>
      </div>

      <div class="liselect w300">
        <div class="input-group">
          <input type="text" class="form-control example-typeahead"
                 placeholder="请输入员工姓名">
          <span class="input-group-btn">
                            <button class="btn btn-success"><i class="fa fa-search"></i></button>
                        </span>
        </div>
      </div>
    </div>
  </div>


  <div class="tablebox">
    <table class="table table-bordered">
      <thead>
      <tr>
        <th class="text-center">员工编号</th>
        <th>员工姓名</th>
        <th>员工职位</th>
        <th>经理编号</th>
        <th>员工入职日期</th>
        <th>员工薪资</th>
        <th>员工奖金</th>
        <th>部门编号</th>
        <th class="text-center" width="85"><i class="fa fa-bolt"></i> 操作</th>
      </tr>
      </thead>
      <tbody>

      <c:forEach items="${requestScope.page.items}" var="emp">
      <tr>
        <td class="cell-small text-center">${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.job}</td>
        <td>${emp.mgr}</td>
        <td>${emp.hiredate}</td>
        <td>${emp.sal}</td>
        <td>${emp.comm}</td>
        <td>${emp.deptno}</td>
        <td class="text-center">
          <div class="btn-group">
            <a href="empServlet?action=getEmp&empno=${emp.empno}&pageNo=${requestScope.page.pageNo}" target="rightiframe" class="btn btn-xs btn-success"><i
                    class="fa fa-pencil"></i></a>
            <a href="empServlet?action=delete&empno=${emp.empno}&pageNo=${requestScope.page.pageNo}" class="btn btn-xs btn-danger deleteClass"><i class="fa fa-trash-o"></i></a>
          </div>
        </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <%@include file="page_nav.jsp"%>

</div>


<!-- 000 -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
      </div>
      <form action="empServlet" method="post">
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <input type="hidden" name="action" value="add">
      <div class="modal-body">

        <div class="form-group">
          <label>员工姓名</label>
          <input type="text" name="ename" class="form-control" placeholder="请输入">
        </div>

        <div class="form-group">
          <label>员工职位</label>
          <input type="text" name="job" class="form-control" placeholder="请输入">
        </div>

        <div class="form-group">
          <label>经理编号</label>
          <input type="text" name="mgr" class="form-control" placeholder="请输入">
        </div>

        <div class="form-group">
          <label>员工入职日期</label>
          <input type="text" id="mydate" placeholder="请选择入职时间段"
                 name="hiredate" class="form-control cursorpointer" >
        </div>

        <div class="form-group">
          <label>员工薪资</label>
          <input type="text" name="sal" class="form-control" placeholder="请输入">
        </div>

        <div class="form-group">
          <label>员工奖金</label>
          <input type="text" name="comm" class="form-control" placeholder="请输入">
        </div>

        <div class="form-group">
          <label>部门编号</label>
          <input type="text" name="deptno" class="form-control" placeholder="请输入">
        </div>

      </div>
      <div class="modal-footer">
        <button class="btn btn-danger" data-dismiss="modal">取消</button>
        <button class="btn btn-success" onclick="" type="submit">提交</button>
        <!--            <input type="submit" class="btn btn-success" value="提交">  -->
      </div>
      </form>
    </div>
  </div>
</div>

<!-- 000 -->
<!-- /* // ****222后台页面定制，设计QQ：951252660 */ -->
<script>
  $('.dropdown-toggle').dropdown();
  $(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })

  //日期范围
  laydate.render({
    elem: '#date',
    range: true,
    theme: "#5cb85c"
  });

  // 2、创建日期
  laydate.render({
    elem: '#mydate',
    theme:"#5cb85c",
    format: 'yyyy-MM-dd', //指定时间格式
    //value: new Date(), // 创建日期默认为当天
  });
</script>
</body>

</html>


