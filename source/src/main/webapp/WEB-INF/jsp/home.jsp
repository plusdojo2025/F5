<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>せんたくびより | ホーム画面</title>
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/home.css">
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/common.css">
</head>

<body>
<!-- ヘッダーここから -->
<jsp:include page="/WEB-INF/include/header.jsp" />
<!-- ヘッダーここまで -->
<main>
<div id="click-ex"> 
	<p>洗濯表示をクリックすると説明が表示されます！</p>
</div>
<div class="divide">
	<!-- ログの表示 -->
	<section class="log">
		<div class="catetitle">
			<h2 id="news">お知らせ</h2>
		</div>
		<c:forEach var="log" items="${logList}">
		<div class="log-area">
			<p>${log.created_at}</p>
			<p>${log.log_info}</p>
		</div>
		</c:forEach>
	</section>

	<!-- 洗濯表示の表示 -->
	<section class="washmark">
	<div class="marktitle">
	</div>
			<!-- 家庭洗濯の表示 -->
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<div class="catetitle">
					<c:if test="${luncate.laundry_category_name == '家庭洗濯'}">	
						<h2>${luncate.laundry_category_name}</h2>
					</c:if>
				</div>
			</c:forEach>
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 1}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
		
		<!-- 漂白の表示 -->
		<div class="catetitle">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<c:if test="${luncate.laundry_category_name == '漂白'}">	
					<h2>${luncate.laundry_category_name}</h2>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 2}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
		
		<div class="catetitle">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<c:if test="${luncate.laundry_category_name == 'タンブル乾燥'}">	
					<h2>${luncate.laundry_category_name}</h2>
				</c:if>
			</c:forEach>
		</div>
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 3}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
		
		<!-- 自然乾燥の表示 -->
		<div class="catetitle">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<c:if test="${luncate.laundry_category_name == '自然乾燥'}">	
					<h2>${luncate.laundry_category_name}</h2>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 4}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
		
		<div class="catetitle">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<c:if test="${luncate.laundry_category_name == 'アイロン'}">	
					<h2>${luncate.laundry_category_name}</h2>
				</c:if>
			</c:forEach>
		</div>
		
		<!-- アイロンの表示 -->
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 5}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
		    class="washimg" data-info="${mark.washing_mark_info}" data-id="${mark.washing_id}">
		  </c:if>
		</c:forEach>
		</div>
		
		<!-- クリーニングの表示 -->
		<div class="catetitle">
			<c:forEach var="luncate" items="${laundry_categoryList}">
				<c:if test="${luncate.laundry_category_name == 'クリーニング'}">	
					<h2>${luncate.laundry_category_name}</h2>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="mark-grid">
		<c:forEach var="mark" items="${Washing_markList}">
		  <c:if test="${mark.laundry_category_id == 6}">
		    <img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}"
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

<!-- フッターここから -->
<jsp:include page="/WEB-INF/include/footer.jsp" />
<!-- フッターここまで -->
<script src="<%= request.getContextPath() %>/js/home.js"></script>
</body>
</html>