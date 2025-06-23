package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.Log;

public class LogDAO {
	// ログの表示メソッド
	public List<Log> getLog(int user_id){
		Connection conn = null;
		List<Log> logList = new ArrayList<>();
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"root", "password");

			// SQL文を準備する：user_idごとに の上位5件まで最新順
			String sql = (
				    "SELECT log_id, log_info, log.user_id, log.created_at "
				    + "FROM log "
				    + "WHERE user_id = ? "
				    + "ORDER BY log.log_id DESC LIMIT 5"
				);


			// プリペアードステートメント
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, user_id);
			
			// SQLを実行して結果を取得
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Log log = new Log(
					rs.getInt("log_id"),
					rs.getString("log_info"),
					rs.getInt("user_id"),
					rs.getString("created_at")
				);
				logList.add(log);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			logList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logList = null;
				}
			}
		}
		return logList;
	}
}
