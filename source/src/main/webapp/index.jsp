<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>せんたくびより</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/top.css">
</head>

<body>
<!-- ヘッダーここから -->
<header class="header">
     <div class="title-top">
        <h1 class="main-title">せんたくびより</h1>
        <h2 class="subtitle">～wash of life～</h2>
    </div>
    <nav class="nav">
        <ul>
            <li><a href="${pageContext.request.contextPath}/LoginServlet">ログイン</a></li> 
            <li><a href="${pageContext.request.contextPath}/UserRegistServlet">新規登録</a></li>
        </ul>
    </nav>
</header>
<!-- ヘッダーここまで -->

<!-- メインここから -->
<main class="main-top">
    <div class="image-top">
        <img src="img/washing_mark.png" alt="洗濯表示一覧">
        <img src="img/laundry_regist.png" alt="洋服登録">
        <img src="img/memo.png" alt="メモ">
    </div>

    <div class="text-top">
        <p>洗濯表示を一覧でチェック！クリックすると、それぞれの意味が簡単に確認できます！</p>
        <p>洋服や布類など日頃の洗濯物を登録できます！登録した情報はいつでも見返すことができます！</p>
        <p>洗濯物の登録時にはオリジナルの洗い方や衣類の気になる箇所をメモすることができます！</p>
    </div>

    <div class="regist2_button">
        <a href="${pageContext.request.contextPath}/UserRegistServlet">まずはこちらから新規登録へ！</a>
    </div>
</main>
<!-- メインここまで -->

<!-- フッターここから -->

<!-- フッターここまで -->
</body>
</html>