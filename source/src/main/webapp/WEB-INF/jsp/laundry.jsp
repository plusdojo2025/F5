<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>せんたくびより | 洗濯物一覧</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/laundry.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">

<style>
* {
	/* outline: 1px solid #FF0000 */;
	
}
</style>
</head>

<body>


	<jsp:include page="/WEB-INF/include/header.jsp" />

	<div class="clothes">

		<div class="search">
			<!-- 絞り込み条件プルダウン（ALLとお気に入り） -->
			<form method="POST" action="" id="filterForm">
				<select name="filter"
					onchange="document.getElementById('filterForm').action=this.value; this.form.submit();">
					<!-- filterの条件がture(?)だった場合にselectedを付けて表示　false(:)の場合に’’空文字にする -->
					<option value="<%= request.getContextPath() %>/LaundryServlet"
						${filter == 'all' ? 'selected' : ''}>ALL</option>
					<option value="<%= request.getContextPath() %>/LaundrySearchServlet"
						${filter == 'favorite' ? 'selected' : ''}>お気に入り</option>
				</select>
			</form>
		</div>

		<!-- カテゴリー名別洗濯物一覧 -->
		<h2 class="category_name">トップス</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 1}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
						<%-- <p>clothes_id = ${c.clothes_id}</p> --%>
						<%-- <c:out value="${c.clothes_id}" default="NULL"/> --%>
						
					</div>
				</c:if>
			</c:forEach>
		</div>
		<!-- お気に入りのみ表示 -->
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 1}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">ボトムズ</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 2}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 2}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">アウター</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 3}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 3}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">ワンピース</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 4}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 4}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">スーツ</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 5}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 5}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">その他</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 6}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 6}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<h2 class="category_name">ファブリック</h2>
		<div class="clothes-container">
			<c:forEach var="c" items="${clothesList}">
				<c:if test="${c.category_id == 7}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${c.user_id}">
							<input type="hidden" name="clothes_id" value="${c.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${c.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="clothes-container">
			<c:forEach var="f" items="${favoriteList}">
				<c:if test="${f.category_id == 7}">
					<div class="clothes-item">
						<form method="POST"
							action="<%=request.getContextPath()%>/LaundryDetailUDServlet">
							<input type="hidden" name="user_id" value="${f.user_id}">
							<input type="hidden" name="clothes_id" value="${f.clothes_id}">
							<img
								src="<%=request.getContextPath()%>/Image_ClothesServlet?id=${f.clothes_id}"
								width="150" height="150" onclick="this.parentElement.submit();">
						</form>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>


	<jsp:include page="/WEB-INF/include/footer.jsp" />


	<script src="js/laundry.js"></script>
	
	<script>
		/* console.log(${c.clothes_id}); */
	</script>
</body>

</html>