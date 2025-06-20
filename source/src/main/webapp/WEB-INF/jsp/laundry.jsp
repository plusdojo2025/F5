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

	<c:forEach var="c" items="${clothesList}">
		<div>
			<p><strong>カテゴリID:</strong> ${item.category_id}</p>
		</div>
	</c:forEach>

	<script src=""></script>
</body>

</html>