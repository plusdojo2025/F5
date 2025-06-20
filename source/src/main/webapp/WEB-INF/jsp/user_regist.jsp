<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規登録 | せんたくびより</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/user_regist.css">
</head>

<body>
<!-- ヘッダーここから（ログイン前のヘッダーは個別で作ってます） -->
<header class="header">
    <div class="title-top">
        <h1 class="main-title">新規登録</h1>
    </div>
    <nav class="nav">
        <ul>
            <li><a href="${pageContext.request.contextPath}/TopServlet">戻る</a></li>
        </ul>
    </nav>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから --> 
<main>
<div class="user_regist_form">
    <section>
        <form id="regist_form" action="UserRegistServlet" method="POST">
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
            <div class="form_click">
                <button type="submit">登録する</button>
                <button type="reset">リセット</button>
            </div>
        </form>
    </section>
</div>
</main>
<!-- メインここまで -->

<!-- フッターは共通 -->

</body>
</html>