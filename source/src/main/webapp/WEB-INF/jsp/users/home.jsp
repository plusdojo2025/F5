<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>せんたくびより | ホーム画面</title>
</head>
<body>
<h1 class="main-title">せんたくびより</h1>
<h2 class="subtitle">～wash of life～</h2>
<!-- logtest -->
<p>ログの情報<p>


<c:set var="categoryname" value=""/>
<c:forEach var="mark" items="${Washing_markList}">
	<!-- categorynameとmark.laundry_category_nameが違ったら-->
    <c:if test="${categoryname != mark.laundry_category_name}">
        <h2>${mark.laundry_category_name}</h2>
        <c:set var="categoryname" value="${mark.laundry_category_name}" />
    </c:if>
  <p>${mark.washing_mark_info}</p> 
</c:forEach>
</body>
</html>