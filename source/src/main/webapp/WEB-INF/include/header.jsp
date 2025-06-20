<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <ul>
        <li><a href="/F5/contoller/HomeServlet">ホーム</a></li>
        <li><a href="${pageContext.request.contextPath}/LaundryRegistServlet">洗濯物登録</a></li>
        <li><a href="${pageContext.request.contextPath}/LaundryServlet">洗濯物一覧</a></li>
        <li><a href="${pageContext.request.contextPath}/HelpServlet">ヘルプ</a></li>
        <li><a href="${pageContext.request.contextPath}/LogoutServlet">ログアウト</a></li>
    </ul>
</body>
</html>