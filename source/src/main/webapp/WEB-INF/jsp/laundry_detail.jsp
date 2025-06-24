<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/laundry_cud.css">
<title>せんたくびより|更新・削除</title>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/include/header.jsp" />
</header>
	<main>
		<form action="${pageContext.request.contextPath}/LaundryDetailUDServlet" method="POST" enctype="multipart/form-data">
		<div class="left">
			<div class="preview-upload">
				<!-- 画像プレビュー -->
				<c:choose>
					<c:when test="${notempty laundry.clothes_img}">
						<img src="<%= request.getContextPath() %>/ImageServlet?clothes_id=${laundry.clothes_id}" alt="画像" width="150">
					</c:when>
					<c:otherwise>
						<img src="$<%= request.getContextPath() %>/img/clothes.png" alt="デフォルト画像" width="150">
					</c:otherwise>
				</c:choose>
				
				<!-- お気に入りチェックボックス -->
				<label for="favorite" class="favorite-icon">
					<input type="checkbox" id="favorite" name="favorite" value="true" <c:if test="${laundry.favorite}">checked</c:if>>
					<span class="star"></span>
				</label>
			</div>
			
			<!-- 洗濯物の画像アップロード -->
			<label for="clothes_img" class="clothes_img">写真アップロード</label>
			<input type="file" id="clothes_img" name="clothes_img" class="file-input"><br>
			
			<!-- 洗濯物のカテゴリー選択 -->
			<select id="category_id" name="category_id" required>
				<option value="" disabled <c:if test="${empty laundry.category_id == 1}">selected</c:if>>衣類カテゴリー洗濯</option>
				<option value="1" <c:if test="${laundry.category_id == 1}">selected</c:if>>トップス</option> 
				<option value="2" <c:if test="${laundry.category_id == 2}">selected</c:if>>ボトムス</option> 
				<option value="3" <c:if test="${laundry.category_id == 3}">selected</c:if>>アウター</option> 
				<option value="4" <c:if test="${laundry.category_id == 4}">selected</c:if>>ワンピース</option> 
				<option value="5" <c:if test="${laundry.category_id == 5}">selected</c:if>>スーツ</option> 
				<option value="6" <c:if test="${laundry.category_id == 6}">selected</c:if>>その他</option>
				<option value="7" <c:if test="${laundry.category_id == 7}">selected</c:if>>ファブリック</option>  
			</select><br>
			
			<!-- メモ入力欄 -->
			<textarea id="remarks" name="remarks" placeholder="メモ入力欄">
				<c:if test="${not empty laundry}">
					${laundry.remarks}
				</c:if>
			</textarea><br>
		</div>
		
		<div class="right">
			<!-- 洗濯表示カテゴリー名の表示 -->
	        <div class="right-check">
	        <c:forEach var="category" items="${laundry_categoryList}">
        		<p class="category_name">${category.laundry_category_name}</p>
        		<c:forEach var="mark" items="${Washing_markList}">
        			<c:if test="${mark.laundry_category_name == category.laundry_category_name}">
        				<label for="${mark.washing_id}" class="icon-label">
        				<input type="checkbox" name="washing_mark" id="${mark.washing_id}" value="${mark.washing_id}">
                           <c:if test="${selectedMarkIds.contains(mark.washing_id)}">checked</c:if>
        				<img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}" width="35" height="auto">
        				</label>
        			</c:if>
        		</c:forEach>
	        </c:forEach><br>
	        </div>
	        <input type="submit" name="action" value="登録">
            <input type="submit" name="action" value="削除">
		</div>
		</form>
	</main>
<footer>
<jsp:include page="/WEB-INF/include/footer.jsp" />
</footer>
</body>
</html>