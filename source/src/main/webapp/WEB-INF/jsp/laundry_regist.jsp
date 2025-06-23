<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/laundry_cud.css">
    <title>せんたくびより|登録</title>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/include/header.jsp" />
</header>
	<main>
    	<form action="${pageContext.request.contextPath}/LaundryRegistServlet" method="POST" enctype="multipart/form-data">
    		<div class="left">
    			<!-- 画像プレビュー -->
    			<img src="${pageContext.request.contextPath}/img/clothes.png" alt="デフォルト画像" width="150"><br>
    			
    			<!-- 洗濯物の画像アップロード -->
		        <label for="clothes_img">写真のアップロード</label>
		        <input type="file" id="clothes_img" name="clothes_img" class="file-input"><br>
		        
		        <!-- お気に入りチェックボックス -->
		        <label for="favorite">お気に入り:</label>
		        <input type="checkbox" id="favorite" name="favorite" value="true"><br>
		        
		        <!-- 洗濯物のカテゴリ選択 -->
		        <select id="category_id" name="category_id" required>
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
		        <input type="text" id="remarks" name="remarks" placeholder="メモ入力欄"><br>
		
		        
			</div>
			
			<div class="right">
		        <!-- 洗濯表示カテゴリー名の表示 -->
		        <c:forEach var="category" items="${laundry_categoryList}">
	        		<p class="category_name">${category.laundry_category_name}</p>
	        		<c:forEach var="mark" items="${Washing_markList}">
	        			<c:if test="${mark.laundry_category_name == category.laundry_category_name}">
	        				<label for="${mark.washing_id}" class="icon-label">
	        				<input type="checkbox" name="washing_mark" id="${mark.washing_id}" value="${mark.washing_id}">
	        				<img src="${pageContext.request.contextPath}/ImageServlet?id=${mark.washing_id}" width="35" height="auto">
	        				</label>
	        			</c:if>
	        		</c:forEach>
		        </c:forEach><br>
	        	<input type="submit" value="登録">
	        </div>
    	</form>
    </main>
<footer>
<jsp:include page="/WEB-INF/include/footer.jsp" />
</footer>
</body>
</html>
