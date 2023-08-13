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
<div id="system">
  <header>
    <div class="left">
      <a href="">
        <i class="gi gi-leaf"></i> Leaf · <small>Cms</small>
      </a>
    </div>
    <div class="right">
      <a href="login.jsp" title="退出">
        <i class="fa fa-power-off"></i>
      </a>
    </div>
  </header>
  <section class="body">
    <div class="left">
      <div class="navbar">
        <dl>
          <dt><a href="controlpanel.jsp" target="rightiframe"><i class="fa fa-fw fa-tachometer"></i><span>控制面板</span></a>
          </dt>
        </dl>

        <dl>
          <dt><i class="fa fa-fw fa-user"></i> <span>员工管理</span></dt>
          <dd>
            <div class='li'>
              <a href="empServlet?action=page" target="rightiframe"><i
                      class="fa fa-fw fa-angle-right"></i><span>查看员工</span></a>
            </div>
          </dd>
        </dl>
      </div>
    </div>
    <div class="right">
      <iframe src="controlpanel.jsp" frameborder="0" id="rightiframe" name="rightiframe"></iframe>
    </div>
  </section>
  <div class="rightmask"></div>
</div>

<script>
  $('.navbar dl dt').click(function () {
    if (!$(this).siblings('dd').hasClass('active')) {
      $('.navbar dl dd').removeClass('active');
      $(this).siblings('dd').removeClass('active');
      $(this).siblings('dd').addClass('active');
    } else {
      $('.navbar dl dd').removeClass('active');
      $(this).siblings('dd').removeClass('active');
    }

    if (!$(this).hasClass('activeTop')) {
      $('.navbar dl dt').removeClass('activeTop');
      $(this).removeClass('activeTop');
      $(this).addClass('activeTop');
    } else {
      $('.navbar dl dt').removeClass('activeTop');
      $(this).removeClass('activeTop');
    }
  })

  $('.navbar .li a').click(function () {
    $('.navbar .li a').removeClass('activelinks');
    $(this).addClass('activelinks');
  })

  $('.body .left').hover(function () {
    $('.rightmask').addClass('show');
  }, function () {
    $('.rightmask').removeClass('show');
  })


</script>
</body>

</html>
