<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>洗濯物登録</title>
</head>
<body>
    <h2>洗濯物の登録</h2>
    <form action="${pageContext.request.contextPath}/LaundryRegistServlet" method="POST" enctype="multipart/form-data">
        <!-- 洗濯物のカテゴリ選択 -->
        <label for="category_id">カテゴリ:</label>
        <select id="category_id" name="category_id" required>
            <option value="1">シャツ</option>
            <option value="2">ズボン</option>
            <option value="3">コート</option>
            <!-- 他のカテゴリを追加 -->
        </select><br>

        <!-- 洗濯物の画像アップロード -->
        <label for="clothes_img">画像:</label>
        <input type="file" id="clothes_img" name="clothes_img"><br>

        <!-- メモ欄 -->
        <label for="remarks">メモ:</label>
        <textarea id="remarks" name="remarks" rows="4" cols="50" placeholder="メモを記入"></textarea><br>

        <!-- お気に入りチェックボックス -->
        <label for="favorite">お気に入り:</label>
        <input type="checkbox" id="favorite" name="favorite" value="true"><br>

        <!-- ユーザーID（テスト用のダミー値） -->
        <input type="hidden" name="user_id" value="1">

        <!-- 洗濯表示マーク（複数選択可能） -->
        <label for="washing_mark">洗濯表示:</label><br>
        <input type="checkbox" name="washing_mark" value="1"> 手洗い<br>
        <input type="checkbox" name="washing_mark" value="2"> ドライクリーニング<br>
        <input type="checkbox" name="washing_mark" value="3"> 高温注意<br>

        <br>
        <input type="submit" value="登録">
    </form>

    <hr>

    <h3>登録した洗濯物</h3>
    <p>登録した洗濯物が表示されます（テスト用）。</p>
</body>
</html>
