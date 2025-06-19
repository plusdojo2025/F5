<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>洗濯物の登録テスト</title>
</head>
<body>

    <h2>洗濯物登録フォーム</h2>

    <form action="${pageContext.request.contextPath}/LaundryRegistServlet" method="POST" enctype="multipart/form-data">
        
        <!-- ユーザーIDの入力（テスト用） -->
        <input type="hidden" name="user_id" value="1"><br><br>
        
        <!-- 洗濯物のカテゴリ選択 -->
        <label for="category_id">カテゴリ:</label>
        <select name="category_id" id="category_id">
            <option value="1">Tシャツ</option>
            <option value="2">パンツ</option>
            <option value="3">ジャケット</option>
            <option value="4">セーター</option>
        </select><br><br>

        <!-- 洗濯物の詳細入力（備考） -->
        <label for="remarks">備考:</label>
        <textarea name="remarks" id="remarks" rows="4" cols="50"></textarea><br><br>

        <!-- お気に入りにするかどうか -->
        <label for="favorite">お気に入り:</label>
        <input type="checkbox" name="favorite" id="favorite" value="true"><br><br>

        <!-- 洗濯マークの入力 -->
        <label for="washing_mark">洗濯マーク（IDで入力）:</label>
        <input type="text" name="washing_mark" id="washing_mark" placeholder="例: 1,2,3"><br><br>

        <!-- 画像のアップロード -->
        <label for="clothes_img">画像をアップロード:</label>
        <input type="file" name="clothes_img" id="clothes_img"><br><br>

        <!-- 登録ボタン -->
        <button type="submit">登録する</button>
    </form>

</body>
</html>
