package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import models.dto.Clothes;

public class ClothesDAO {
	// 登録処理
	public boolean insert(Clothes clothes, List<Integer> washingMarkIds) {
        Connection conn = null;
        boolean result = false;

        try {
        	// JDBCドライバを読み込む
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
            // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");

            // 自動コミットをOFF（トランザクション）
            conn.setAutoCommit(false);

            // clothes テーブルにINSERT
            String clothessql = "INSERT INTO clothes (clothes_img, category_id, remarks, user_id, favorite) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(clothessql, Statement.RETURN_GENERATED_KEYS);

            // パラメータ設定
            if (clothes.getClothes_img() != null) {
                pStmt.setBytes(1, clothes.getClothes_img());
            } else {
                pStmt.setNull(1, java.sql.Types.BLOB);
            }
            Integer Category_id = clothes.getCategory_id();
            if (Category_id != null) {
                pStmt.setInt(2, clothes.getCategory_id());
            } else {
                pStmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (clothes.getRemarks() != null) {
				pStmt.setString(3, clothes.getRemarks());
			} else {
				pStmt.setString(3, "");
			}
            Integer Users_id = clothes.getUsers_id();
            if (Users_id != null) {
                pStmt.setInt(4, clothes.getUsers_id());
            } else {
                pStmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (clothes.getFavorite() != null) {
                pStmt.setBoolean(5, clothes.getFavorite());
            } else {
                pStmt.setNull(5, java.sql.Types.BOOLEAN);
            }

            // SQL文を実行する
         	if (pStmt.executeUpdate() == 1) {
         		result = true;
            }

            // 自動生成されたclothes_idを取得
            int clothesId = -1;
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                clothesId = rs.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve generated clothes_id.");
            }

            // clothes_mark テーブルにINSERT（洗濯表示）
            if (washingMarkIds != null && !washingMarkIds.isEmpty()) {
                String marksql = "INSERT INTO clothes_mark (clothes_id, washing_mark_id) VALUES (?, ?)";
                PreparedStatement pStmt2 = conn.prepareStatement(marksql);

                for (Integer markId : washingMarkIds) {
                    pStmt2.setInt(1, clothesId);
                    pStmt2.setInt(2, markId);
                    pStmt2.addBatch();
                }
                pStmt2.executeBatch();
                pStmt2.close();
            }

            conn.commit(); // コミット
            result = true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // エラーが出たらロールバック
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
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

        return result;
    }
	
	// 削除処理
	public boolean delete(Clothes clothes) {
		Connection conn = null;
        boolean result = false;
		
        try {
        	// JDBCドライバを読み込む
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
			
			conn.setAutoCommit(false);
		
			String sql = "DELETE FROM clothes WHERE clothes_id = ? AND user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			pStmt.setInt(1, clothes.getClothes_id());
			pStmt.setInt(2, clothes.getUsers_id());	
			
			
			if (pStmt.executeUpdate() > 0) {
				conn.commit();
				result = true;
			}
			
			
			
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // エラーが出たらロールバック
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
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
	
	// 更新処理
	public boolean update(Clothes clothes, List<Integer> washingMarkIds) {
		Connection conn = null;
		boolean result = false;
		
		try {
        	// JDBCドライバを読み込む
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE clothes SET clothes_img = ?, category_id = ?, remarks = ?, favorite = ? WHERE clothes_id = ? AND user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// パラメータ設定
            if (clothes.getClothes_img() != null) {
                pStmt.setBytes(1, clothes.getClothes_img());
            } else {
                pStmt.setNull(1, java.sql.Types.BLOB);
            }
            Integer Category_id = clothes.getCategory_id();
            if (Category_id != null) {
                pStmt.setInt(2, clothes.getCategory_id());
            } else {
                pStmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (clothes.getRemarks() != null) {
				pStmt.setString(3, clothes.getRemarks());
			} else {
				pStmt.setString(3, "");
			}
            if (clothes.getFavorite() != null) {
                pStmt.setBoolean(4, clothes.getFavorite());
            } else {
                pStmt.setNull(4, java.sql.Types.BOOLEAN);
            }
            Integer Clothes_id =  clothes.getClothes_id();
            if (Clothes_id != null) {
                pStmt.setNull(5, clothes.getClothes_id());
            } else {
                pStmt.setNull(5, java.sql.Types.INTEGER);
            }
            Integer Users_id = clothes.getUsers_id();
            if (Users_id != null) {
                pStmt.setInt(6, clothes.getUsers_id());
            } else {
                pStmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            // SQL文を実行する
 			if (pStmt.executeUpdate() == 1) {
 				result = true;
 			}
 			
 			// 洗濯表示を削除
 			String delsql = "DELETE FROM clothes_mark WHERE clothes_id = ?";
 			PreparedStatement pStmt2 = conn.prepareStatement(delsql);
 			
 			pStmt2.setInt(1, clothes.getClothes_id());
			
 			// SQL文を実行する
 			if (pStmt2.executeUpdate() == 1) {
 				result = true;
 			}
 			
 			// clothes_mark テーブルにINSERT（洗濯表示）
            if (washingMarkIds != null && !washingMarkIds.isEmpty()) {
                String marksql = "INSERT INTO clothes_mark (clothes_id, washing_mark_id) VALUES (?, ?)";
                PreparedStatement pStmt3 = conn.prepareStatement(marksql);

                for (Integer markId : washingMarkIds) {
                    pStmt3.setInt(1, clothes.getClothes_id());
                    pStmt3.setInt(2, markId);
                    pStmt3.addBatch();
                }
                pStmt3.executeBatch();
                pStmt3.close();
            }
            
            conn.commit();
 			
		}catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // エラーが出たらロールバック
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
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
