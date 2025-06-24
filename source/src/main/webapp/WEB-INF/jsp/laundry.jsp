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

body {
	background-color: #C9E4F4;
}

.clothes {
	margin: 0;
}

.search{
margin:  30px auto;
display: flex;
justify-content: flex-end;
max-width: 1100px;

}

.search select {
  font-size: 18px;   /* フォントを大きくする */
  padding: 10px;     /* セレクトボックスの内側余白を広くする */
}

.search select option {
  font-size: 18px;   /* プルダウン展開時の文字サイズも大きく */
  line-height: 2;    /* 行の高さを広くして見た目を大きくする */
}

.category_name{
margin:  30px auto 30px auto;
display: flex;
justify-content: flex-start;
max-width: 1100px;
align-items: center;
color: #FFFFFF;
background-color: #807B84;
border-radius: 10px;


}

.clothes-container {
	display: grid;
	grid-template-columns: repeat(5, 1fr); /* 5列にする */
	gap: 20px;
	margin: 0 auto;
	
	max-width: 1100px;
	align-items: center;
}

.clothes-item {
	margin: 0 auto;
}
</style>
</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/include/header.jsp" />
	</header>

	<div class="clothes">

		<div class="search">
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
		</div>

		<h2 class="category_name">トップス</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 1}">
					<div class="clothes-item">
						<form method="POST" action="/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="${pageContext.request.contextPath}/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>







	</div>





	<!-- 初期値を設定 -->
	<%-- <c:set var="prevname" value="" />
	<div class="clothes-container">
		<!-- clothesListを繰り返しで表示 -->
		<c:forEach var="c" items="${clothesList}">
			<!-- カテゴリー名が前回と違えば表示する -->
			<c:if test="${prevname != c.category_name}">
				<!-- カテゴリー名を表示 -->
				<h2>${c.category_name}</h2>
				<!-- 今回のカテゴリー名をprevnameにセットする -->
				<c:set var="prevname" value="${c.category_name}" />
			</c:if>
			<div class="clothes-item">
				<!-- 洗濯物画像の表示 -->
				<img
					src="${pageContext.request.contextPath}/Image_ClothesServlet?id=${c.clothes_id}"
					width="150" height="150">
			</div>
		</c:forEach>
	</div> --%>

	<!-- お気に入りのサーブレット・favoriteListを繰り返しで表示 -->
	<%-- <c:forEach var="f" items="${favoriteList}">
		<!-- カテゴリー名が前回と違えば表示する -->
		<c:if test="${prevname != f.category_name}">
			<!-- カテゴリー名を表示 -->
			<h2>${f.category_name}</h2>
			<!-- 今回のカテゴリー名をprevnameにセットする -->
			<c:set var="prevname" value="${f.category_name}" />
		</c:if>
		<!-- 洗濯物画像の表示 -->
		<img
			src="${pageContext.request.contextPath}/Image_ClothesServlet?id= ${f.clothes_id}"
			width="150" height="150">
	</c:forEach> --%>


	<footer>
		<jsp:include page="/WEB-INF/include/footer.jsp" />
	</footer>

	<script src="js/laundry.js"></script>
</body>

</html>