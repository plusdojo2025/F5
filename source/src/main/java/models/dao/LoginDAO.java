package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.dto.Users;

public class LoginDAO {
	// 引数で指定されたemailとpasswordでログイン成功ならtrueを返す
    public boolean isLoginOK(Users users) {
        Connection conn = null;
        boolean loginResult = false;

        try {
            // JDBCドライバ読み込み
            Class.forName("com.mysql.cj.jdbc.Driver");

            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?" 
            		+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                    "root", "password");

            // SELECT文を準備する
            String sql = "SELECT COUNT(*) FROM users WHERE email=? AND password=?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, users.getEmail());
            pStmt.setString(2, users.getPassword());

            // SELECT文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();

            // メールアドレスとパスワードが一致するユーザーがいれば結果をtrueにする
            rs.next();
            if (rs.getInt(1) == 1) {
                loginResult = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            loginResult = false;
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    loginResult = false;
                }
            }
        }

        //結果を返す
        return loginResult;
    }
}
        


