<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/laundry_cud.css">
    <title>せんたくびより|登録</title>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/include/header.jsp" />
</header>
	<main>
    	<form action="<%= request.getContextPath() %>/LaundryRegistServlet" method="POST" id="form" enctype="multipart/form-data" accept-charset="UTF-8">
    		<div class="left">
    			<div class="preview-upload">
	    			<!-- 画像プレビュー -->
	    			<img src="<%= request.getContextPath() %>/img/clothes.png" id="imagePreview" alt="デフォルト画像" width="150" height="150">
	    			<!-- お気に入りチェックボックス -->
	    			
			        <label for="favorite" class="favorite-icon">
				        <input type="checkbox" id="favorite" name="favorite" value="true">
				        <span class="star"></span>
			        </label>
			        
		    	</div>
    			<!-- 洗濯物の画像アップロード -->
		        <label for="clothes_img" class="clothes_img">写真のアップロード</label>
		        <input type="file" id="clothes_img" name="clothes_img" class="file-input"><br>
		        
		        
		        
		        
		        <!-- 洗濯物のカテゴリ選択 -->
		        <select id="category_id" name="category_id">
		        	<option value="" disabled selected>衣類カテゴリー選択</option>
		            <option value="1">トップス</option>
		            <option value="2">ボトムス</option>
		            <option value="3">アウター</option>
		            <option value="4">ワンピース</option>
		            <option value="5">スーツ</option>
		            <option value="6">その他</option>
		            <option value="7">ファブリック</option>
		        </select><br>

		        <!-- メモ欄 -->
		        <textarea id="remarks" name="remarks" placeholder="メモ入力欄"></textarea><br>
		
		        
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
	        				<img src="<%= request.getContextPath() %>/ImageServlet?id=${mark.washing_id}" width="35" height="auto">
	        				</label>
	        			</c:if>
	        		</c:forEach>
		        </c:forEach><br>
		        </div>
		        <div class="action-submit">
		        	<input type="submit" id="registButton" value="登録">
		        </div>
	        </div>
    	</form>
    </main>

<jsp:include page="/WEB-INF/include/footer.jsp" />
<script src="<%= request.getContextPath() %>/js/laundry_cud.js"></script>
</body>
</html>
