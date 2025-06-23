<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>洗濯物一覧 | TACOS</title>
<link rel="stylesheet" href="">

<style>
* {
	outline: 1px solid #FF0000;
}
</style>
</head>

<body>

<header>
<jsp:include page="/WEB-INF/include/header.jsp" />
</header>
	
	<!-- 絞り込み条件プルダウン（ALLとお気に入り） -->
	<form method="POST" action="" id="filterForm">
		<select name="filter"
			onchange="document.getElementById('filterForm').action=this.value; this.form.submit();">
			<!-- filterの条件がture(?)だった場合にselectedを付けて表示　false(:)の場合に’’空文字にする -->
			<option value="/F5/LaundryServlet"
				${filter == 'all' ? 'selected' : ''}>ALL</option>
			<option value="/F5/LaundrySearchServlet"
				${filter == 'favorite' ? 'selected' : ''}>お気に入り</option>
		</select>
	</form>
	
	<!-- 初期値を設定 -->
	<c:set var="prevname" value="" />
	<!-- clothesListを繰り返しで表示 -->
	<c:forEach var="c" items="${clothesList}">
		<!-- カテゴリー名が前回と違えば表示する -->
		<c:if test="${prevname != c.category_name}">
			<!-- カテゴリー名を表示 -->
			<h2>${c.category_name}</h2>
			<!-- 今回のカテゴリー名をprevnameにセットする -->
			<c:set var="prevname" value="${c.category_name}" />
		</c:if>
		
		<!-- 洗濯物画像の表示 -->
		<img src = "${pageContext.request.contextPath}/Image_ClothesServlet? id= c.clothes_id">${c.clothes_id}
		
	</c:forEach>
	
<footer>
<jsp:include page="/WEB-INF/include/footer.jsp" />
</footer>

	<script src=""></script>
</body>

</html>