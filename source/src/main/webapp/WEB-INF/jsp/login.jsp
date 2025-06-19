<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>せんたくびより</title>
    <link rel="stylesheet" href="css/common.css">
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
                    <label for="id">メールアドレス</label>
                    <input type="email" name="email" id="id" placeholder="メールアドレスを入力してください">
                </div>
                <div class="form_row">
                    <label for="pw">パスワード</label>
                    <input type="password" name="password" id="pw" placeholder="パスワードを入力してください">
                </div>
            </div>
            <button type="submit">ログイン</button>
            <p id="output" style="color: #4A3E37;"></p> <!-- エラーメッセージ表示用 -->
        </form>
  </section>
</div>
<div class="user_regist_button">
    <a href="user_regist.jsp">新規登録はこちら</a>
</div>
</main>
<!-- メインここまで -->

<!-- フッターここから -->
<footer>
    <p class="copyright">&copy; せんたくびより</p>
</footer>
<!-- フッターここまで -->

</body>
</html>