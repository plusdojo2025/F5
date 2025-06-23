<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン | せんたくびより</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
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
        <form id="form" action="/F5/LoginServlet" method="POST">
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
            <p id="output" style="color: #4A3E37;"></p> <!-- エラーメッセージ表示用 -->
            <button type="submit">ログイン</button>
        </form>
  </section>
</div>
<div class="user_regist_button">
    <a href="${pageContext.request.contextPath}/UserRegistServlet">新規登録はこちら</a>
</div>
</main>
<!-- メインここまで -->

<!-- フッターここから -->
<jsp:include page="/WEB-INF/include/footer.jsp" />
<!-- フッターここまで -->

</body>
</html>