<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
<div class="title">
	<h1 class="main-title">せんたくびより</h1>
	<h2 class="subtitle">~Wash of Life~</h2>
</div>
<nav class="nav-menu">
	<ul>
        <li><a href="<%= request.getContextPath() %>/HomeServlet">ホーム</a></li>
        <li class="arrow">▶</li>
        <li class="regist"><a href="<%= request.getContextPath() %>/LaundryRegistServlet">洗濯物登録</a></li>
        <li class="arrow">▶</li>
        <li class="list"><a href="<%= request.getContextPath() %>/LaundryServlet">洗濯物一覧</a></li>
        <li><a href="<%= request.getContextPath() %>/HelpServlet">ヘルプ</a></li>
        <li class="logout"><a href="<%= request.getContextPath() %>/LogoutServlet">ログアウト</a></li>
	</ul>
</nav>
</header>
