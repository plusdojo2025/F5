<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>せんたくびより | 新規登録</title>
    <link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/common.css">
    <link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/user_regist.css">
</head>

<body>
<!-- ヘッダーここから（ログイン前のヘッダーは個別で作ってます） -->
<header class="header">
    <div class="title-top">
        <h1 class="main-title">新規登録</h1>
    </div>
    <nav class="nav">
        <ul>
             <li><a href="<%= request.getContextPath() %>/TopServlet">戻る</a></li>
        </ul>
    </nav>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから --> 
<main>
<div class="user_regist_form">
    <section>
        <form id="regist_form" action="<%= request.getContextPath() %>/UserRegistServlet" method="POST">
            <div class="login_form_btm">
                <div class="regist_form_row">
                    <label for="nickname">ニックネーム</label>
                    <input type="text" name="nickname" id="nickname">
                </div>
                <div class="regist_form_row">
                    <label for="email">メールアドレス</label>
                    <input type="email" name="email" id="email">
                </div>
                <div class="regist_form_row">
                    <label for="password">パスワード</label>
                    <input type="password" name="password" id="password">
                </div>
                <div class="regist_form_row">
                    <label for="password_check">パスワード確認</label>
                    <input type="password" name="password_check" id="password_check">
                </div>
            </div>
            <p id="output" style="color: #4A3E37;"></p> <!-- エラーメッセージ表示用 -->
            <div class="form_click">
                <button type="submit">登録する</button>
                <button type="reset">リセット</button>
            </div>
        </form>
    </section>
</div>
</main>
<!-- メインここまで -->

<!-- フッターここから -->
<jsp:include page="/WEB-INF/include/footer.jsp" />
<!-- フッターここから -->

<!-- JavaScriptここから -->
<script src="${pageContext.request.contextPath}/js/user_regist.js"></script>
<!-- JavaScriptここまで -->
</body>
</html>