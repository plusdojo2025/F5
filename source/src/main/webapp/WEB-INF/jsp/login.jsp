<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>せんたくびより | ログイン</title>
    <link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/common.css">
    <link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/login.css">
</head>

<body>
<!-- ヘッダーここから -->
<header class="header">
     <div class="title-top">
        <h1 class="main-title">せんたくびより</h1>
        <h2 class="subtitle">～wash of life～</h2>
    </div>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから --> 
<main>
<div class="login_form">  
    <section>
        <form id="form" action="<%= request.getContextPath() %>/LoginServlet" method="POST">
            <div class="login_form_btm">
                <div class="form_row">
                    <label for="email">メールアドレス</label>
                    <input type="email" name="email" id="email">
                </div>
                <div class="form_row">
                    <label for="password">パスワード</label>
                    <input type="password" name="password" id="password">
                </div>
            </div>
            <p id="output" style="color: #4A3E37;">${error}</p> <!-- エラーメッセージ表示用 -->
            <button type="submit">ログイン</button>
        </form>
  </section>
</div>
<div class="user_regist_button">
    <a href="<%= request.getContextPath() %>/UserRegistServlet">新規登録はこちら</a>
</div>
</main>
<!-- メインここまで -->

<!-- フッターここから -->
<jsp:include page="/WEB-INF/include/footer.jsp" />
<!-- フッターここまで -->

<!-- JavaScriptここから -->
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<!-- JavaScriptここまで -->
</body>
</html>