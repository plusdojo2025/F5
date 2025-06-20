<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>せんたくびより | ホーム画面</title>
<link rel="stylesheet" href="/F5/css/home.css">
</head>
</head>

<body>
<header>
<ul>
<li><a href="/F5/contoller/HomeServlet">ホーム</a></li>
                <li><a href="${pageContext.request.contextPath}/LaundryRegistServlet">洗濯物登録</a></li>
                <li><a href="${pageContext.request.contextPath}/LaundryServlet">洗濯物一覧</a></li>
                <li><a href="${pageContext.request.contextPath}/HelpServlet">ヘルプ</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">ログアウト</a></li>
</ul>
</header>
<main>
<h1 class="main-title">せんたくびより</h1>
<h2 class="subtitle">～wash of life～</h2>
<!-- logtest -->
<p>ログの情報<p>
<c:forEach var="log" items="${logList}">
	<p>${log.log_info}</p>
</c:forEach>
<p>画像の表示</p>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == '家庭洗濯'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>

<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 1}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == '漂白'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>

<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 2}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == 'タンブル乾燥'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>
<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 3}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == '自然乾燥'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>

<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 4}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == 'アイロン'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>

<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 5}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>

<div class="catetitle">
	<c:forEach var="luncate" items="${laundry_categoryList}">
		<c:if test="${luncate.laundry_category_name == 'クリーニング'}">	
			<p>${luncate.laundry_category_name}</p>
		</c:if>
	</c:forEach>
</div>

<div class="img-row">
<c:forEach var="mark" items="${Washing_markList}">
  <c:if test="${mark.laundry_category_id == 6}">
    <img src="${mark.washing_mark_icon}">
  </c:if>
</c:forEach>
</div>
</main>
</body>
</html>