package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.dto.Users;

public class UsersDAO {
	
	public Users select(int user_id) {
		Connection conn = null;
		Users user = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DBへ接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

	
			String sql = "SELECT user_id,password,nickname,email,photo,created_at,updated_at FROM Users WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);

			// クエリを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();
			
			
			// 結果セットの各行をBcオブジェクトに変換しリストへ追加
			if(rs.next()) {
				user = new Users(
						rs.getInt("user_id"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getBytes("photo"),
						rs.getString("created_at"),
						rs.getString("updated_at")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;		// エラー時はnullを返す
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 検索結果のリストを返す
		return user;
	}
	
	public Users login_select(String email) {
		Connection conn = null;
		Users user = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DBへ接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

	
			String sql = "SELECT user_id,password,nickname,email,photo,created_at,updated_at FROM users WHERE email = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, email);

			// クエリを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();
			
			
			// 結果セットの各行をBcオブジェクトに変換しリストへ追加
			if(rs.next()) {
				user = new Users(
						rs.getInt("user_id"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getBytes("photo"),
						rs.getString("created_at"),
						rs.getString("updated_at")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;		// エラー時はnullを返す
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 検索結果のリストを返す
		return user;
	}
	public boolean insert(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
//			private int user_id;		 //ユーザーID
//			private String password;	 //パスワード
//			private String nickname;	 //ニックネーム
//			private String email;		 //メールアドレス
//			private byte[] photo;			 //写真情報
//			private String created_at;	 //登録日
//			private String updated_at;	 //更新日
			
			// SQL文を準備する 
			String sql = "INSERT INTO Users VALUES (0, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user.getPassword() != null) {
				pStmt.setString(1, user.getPassword());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getNickname() != null) {
				pStmt.setString(2, user.getNickname());
			} else {
				pStmt.setString(2, "");
			}
			if (user.getEmail() != null) {
				pStmt.setString(3, user.getEmail());
			} else {
				pStmt.setString(3, "");
			}
			if (user.getPhoto() != null) {
				pStmt.setBytes(4, user.getPhoto());
			} else {
				pStmt.setNull(4, java.sql.Types.BLOB);
			}
			if (user.getCreated_at() != null) {
				pStmt.setString(5, user.getCreated_at());
			} else {
				pStmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			if (user.getUpdated_at() != null) {
				pStmt.setString(6, user.getUpdated_at());
			} else {
				pStmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
						// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	
	public boolean update(Users user) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		PreparedStatement logStmt = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			conn.setAutoCommit(false); //トランザクション開始
			// SQL文を準備する
			String sql = "UPDATE Users SET password = ?,nickname = ?,email = ?,photo=?,created_at = ?,updated_at=? WHERE user_id=?";
			pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			if (user.getPassword() != null) {
				pStmt.setString(1, user.getPassword());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getNickname() != null) {
				pStmt.setString(2, user.getNickname());
			} else {
				pStmt.setString(2, "");
			}
			if (user.getEmail() != null) {
				pStmt.setString(3, user.getEmail());
			} else {
				pStmt.setString(3, "");
			}
			if (user.getPhoto() != null) {
				pStmt.setBytes(4, user.getPhoto());
			} else {
				pStmt.setNull(4, java.sql.Types.BLOB);
			}
			if (user.getCreated_at() != null) {
				pStmt.setString(5, user.getCreated_at());
			} else {
				pStmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			if (user.getUpdated_at() != null) {
				pStmt.setString(6, user.getUpdated_at());
			} else {
				pStmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			pStmt.setInt(7, user.getUser_id());
				
			int updateCount = pStmt.executeUpdate();
			if (updateCount == 1) {
	            // ログ登録用SQL
	            String sqlLog = "INSERT INTO log(log_id, log_info,user_id, created_at) VALUES (0,?, ?, NOW())";
	            logStmt = conn.prepareStatement(sqlLog);
	            
	            logStmt.setString(1, "ユーザー情報が変更されました");
	            logStmt.setInt(2, user.getUser_id());
	            int logCount = logStmt.executeUpdate();

	            if (logCount == 1) {
	                conn.commit();
	                result = true;
	            } else {
	                conn.rollback();
	            }
	        } else {
	            conn.rollback();
	        }
		} catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        try {
	            if (conn != null) conn.rollback();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    } finally {
	        try {
	            if (pStmt != null) pStmt.close();
	            if (logStmt != null) logStmt.close();
	            if (conn != null) {
	                conn.setAutoCommit(true);
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result;
	}
	
	public boolean delete(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "DELETE FROM Users WHERE user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, user.getUser_id());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
