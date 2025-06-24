<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/help.css">
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/common.css">
<title>せんたくびより | ヘルプ</title>
</head>
<body>
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/include/header.jsp" />
<!-- ヘッダーここまで -->
<main>
	<h1 class="helptitle">せんたくびよりの使い方</h1>
		<div>
			<div class="help_subtitle">
				<h2>洗濯表示</h2>
			</div>
			<ul class="help_explain">
				<li>洗濯表示の意味を知ろう！</li>
				<li>・画面上部の「ホーム」をクリックします。</li>
				<li>・画面の洗濯表示をクリックします。</li>
				<li>・画像をクリックすると洗濯表示の意味を見れます。</li>
			</ul>
		</div>
	<div>
	<div class="help_subtitle">
		<h2 class="subtitle">洗濯物登録</h2>
	</div>
		<ul class="help_explain">
			<li>洗濯物を登録・確認しよう！</li>
			<li>・画面上部の「洗濯物登録」をクリックします。</li>
			<li>・衣類や洗いたい物の写真をアップロードします。</li>
			<li>・衣類のカテゴリと洗濯表示を選んで登録します。</li>
			<li>・メモ欄には、オリジナルの洗い方や気になることを記入できます。</li>
		</ul>
		</div>
	<div>
		<div class="help_subtitle">
			<h2 class="subtitle">洗濯物一覧</h2>
		</div>
		<ul class="help_explain">
			<li>登録した洗濯物を確認しよう！</li>
			<li>・画面上部の「洗濯物一覧」をクリックします。</li>
			<li>・「洗濯物登録」で登録した洗濯物を確認できます。</li>
			<li>・画像をクリックすると洗濯物の詳細を詳しく見れます。</li>
			<li>・洗濯物の詳細から編集・削除をすることができます。</li>
		</ul>
	</div>
</main>
<!-- フッターここから -->
<jsp:include page="/WEB-INF/include/footer.jsp" />
<!-- フッターここまで -->
</body>
</html>