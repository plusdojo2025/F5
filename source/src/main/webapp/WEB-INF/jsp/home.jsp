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

<body>
<header>
<jsp:include page="/WEB-INF/include/header.jsp" />
</header>
<main>
<div class="divide">
	<section class="log">
		<div class="catetitle">
			<p>お知らせ</p>
		</div>
		<c:forEach var="log" items="${logList}">
			<p>${log.log_info}</p>
		</c:forEach>
	</section>
	<section class="washmark">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<div class="catetitle">
					<c:if test="${luncate.laundry_category_name == '家庭洗濯'}">	
						<p>${luncate.laundry_category_name}</p>
					</c:if>
				</div>
			</c:forEach>
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 1}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
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
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 2}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
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
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 3}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
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
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 4}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
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
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 5}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
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
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 6}">
		    <img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
	</section>
</div>

<!-- モーダルの設定 -->
<div id="text-modal" class="modal">
	<div class="modal-box">
		<div class="modal-content">
			<img id="modal-img" src="" alt="" />
			<p id="modal-text"></p>
		</div>
		<div class="modal-footer">
			<span id="ok-text" class="ok-text">OK</span>
		</div>
	</div>
</div>
</main>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>