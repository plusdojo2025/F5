package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.dto.Clothes;
import models.dto.JoinLandry;

public class ClothesDAO {
	
	/* ユーザーが所持している全ての洗濯物を取得してリストにして返す */
	public List<JoinLandry> getAllclothes(int user_id) {
		Connection conn = null;
		List<JoinLandry> clothesList = new ArrayList<JoinLandry>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = "SELECT"
					+ "    c.clothes_id,"
					+ "    c.clothes_img,"
					+ "    c.category_id,"
					+ "    cm.category_name,"
					+ "    c.remarks,"
					+ "    c.user_id,"
					+ "    c.favorite,"
					+ "    c.created_at,"
					+ "    c.updated_at"
					+ " FROM clothes AS c"
					+ " JOIN category_mst AS cm"
					+ " ON c.category_id = cm.category_id"
					+ " WHERE c.user_id = ? ORDER BY c.category_id ";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);


			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				JoinLandry jl = new JoinLandry(
						rs.getInt("user_id"),
						rs.getInt("clothes_id"),
						rs.getBytes("clothes_img"),
						rs.getString("remarks"),
						rs.getBoolean("favorite"),
						rs.getString("created_at"),
						rs.getString("updated_at"),
						rs.getInt("category_id"),
						rs.getString("category_name")
					);
				clothesList.add(jl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			clothesList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			clothesList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					clothesList = null;
				}
			}
		}

		// 結果のリストを返す
		return clothesList;
	}
	
	/* 洗濯物の絞りこみ検索 */
	public List<JoinLandry> FavoriteSearch(int user_id) {
		Connection conn = null;
		List<JoinLandry> favoriteList = new ArrayList<JoinLandry>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = "SELECT"
					+ "    c.clothes_id,"
					+ "    c.clothes_img,"
					+ "    c.category_id,"
					+ "    cm.category_name,"
					+ "    c.remarks,"
					+ "    c.user_id,"
					+ "    c.favorite,"
					+ "    c.created_at,"
					+ "    c.updated_at"
					+ " FROM clothes AS c"
					+ " JOIN category_mst AS cm"
					+ " ON c.category_id = cm.category_id"
					+ " WHERE c.user_id = ? AND favorite = true";
			
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);

			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				JoinLandry jl = new JoinLandry(
						rs.getInt("user_id"),
						rs.getInt("clothes_id"),
						rs.getBytes("clothes_img"),
						rs.getString("remarks"),
						rs.getBoolean("favorite"),
						rs.getString("created_at"),
						rs.getString("updated_at"),
						rs.getInt("category_id"),
						rs.getString("category_name")
					);
				favoriteList.add(jl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			favoriteList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			favoriteList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					favoriteList = null;
				}
			}
		}

		// 結果のリストを返す
		return favoriteList;
	}

	/* ユーザーIDと洗濯物IDを指定してユーザーが所持している洗濯物１つを編集と削除 */
	public List<JoinLandry> GetLaundryUDSelect(int user_id, int clothes_id) {
		Connection conn = null;
		List<JoinLandry> LaundryUDList = new ArrayList<JoinLandry>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文をセットする
			String sql = 
				    "SELECT "
				    + "c.user_id, "
				    + "c.clothes_id, "
				    + "c.clothes_img, "
				    + "c.remarks, "
				    + "c.favorite, "
				    + "c.created_at, "
				    + "c.updated_at, "
				    + "c.category_id, "
				    + "cm.category_name, "
				    + "wm.washing_mark_id, "
				    + "wm.washing_mark_icon, "
				    + "wm.washing_mark_number, "
				    + "lcm.laundry_category_id, "
				    + "lcm.laundry_category_name "
				    + "FROM clothes AS c "
				    + "INNER JOIN category_mst AS cm ON c.category_id = cm.category_id "
				    + "LEFT JOIN clothes_mark cmk ON c.clothes_id = cmk.clothes_id "
				    + "LEFT JOIN washing_mark_mst AS wm ON cmk.washing_mark_id = wm.washing_mark_id "
				    + "LEFT JOIN laundry_category_mst AS lcm ON wm.laundry_category_id = lcm.laundry_category_id "
				    + "WHERE c.user_id = ? AND c.clothes_id = ?";
			
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, user_id);
            pStmt.setInt(2, clothes_id);

			// SQL文を実行し、結果をrsへ格納
			ResultSet rs = pStmt.executeQuery();

			// １行づつ取り出し、結果をclothesListにコピーする
			while (rs.next()) {
				JoinLandry jl = new JoinLandry(
					    rs.getInt("user_id"),
					    rs.getInt("clothes_id"),
					    rs.getBytes("clothes_img"),
					    rs.getString("remarks"),
					    rs.getBoolean("favorite"),
					    rs.getString("created_at"),
					    rs.getString("updated_at"),
					    rs.getInt("category_id"),
					    rs.getString("category_name"),
					    rs.getInt("washing_mark_id"),
					    rs.getBytes("washing_mark_icon"),
					    rs.getInt("washing_mark_number"),
					    rs.getInt("laundry_category_id"),
					    rs.getString("laundry_category_name")
					);
				LaundryUDList.add(jl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LaundryUDList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LaundryUDList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LaundryUDList = null;
				}
			}
		}

		// 結果のリストを返す
		return LaundryUDList;
	}
	
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
            Integer Users_id = clothes.getUser_id();
            if (Users_id != null) {
                pStmt.setInt(4, clothes.getUser_id());
            } else {
                pStmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (clothes.getFavorite() != null) {
                pStmt.setBoolean(5, clothes.getFavorite());
            } else {
                pStmt.setNull(5, java.sql.Types.BOOLEAN);
            }

            // SQL文を実行する
         	int registclCount = pStmt.executeUpdate();

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
            
            // ログ登録
            if (registclCount == 1) {
            	String logsql = "INSERT INTO log(log_id, log_info, user_id, created_at) VALUES (0, ?, ?, NOW())";
				PreparedStatement pStmt3 = conn.prepareStatement(logsql);
				
				pStmt3.setString(1, "洗濯物が登録されました");
				pStmt3.setInt(2, clothes.getUser_id());
				int logCount = pStmt3.executeUpdate();
				
				if (logCount == 1) {
					conn.commit();
					result = true;
				} else {
					conn.rollback();
				}
            }	else {
            	conn.rollback();
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
			pStmt.setInt(2, clothes.getUser_id());	
			
			
			int delCount = pStmt.executeUpdate();
			
			if (delCount == 1) {
            	String logsql = "INSERT INTO log(log_id, log_info, user_id, created_at) VALUES (0, ?, ?, NOW())";
				PreparedStatement pStmt3 = conn.prepareStatement(logsql);
				
				pStmt3.setString(1, "洗濯物が削除されました");
				pStmt3.setInt(2, clothes.getUser_id());
				int logCount = pStmt3.executeUpdate();
				
				if (logCount == 1) {
					conn.commit();
					result = true;
				} else {
					conn.rollback();
				}
            }	else {
            	conn.rollback();
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
                pStmt.setInt(5, clothes.getClothes_id());
            } else {
                pStmt.setNull(5, java.sql.Types.INTEGER);
            }
            Integer Users_id = clothes.getUser_id();
            if (Users_id != null) {
                pStmt.setInt(6, clothes.getUser_id());
            } else {
                pStmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            // SQL文を実行する
 			int updateclCount = pStmt.executeUpdate();
 			
 			// 洗濯表示を削除
 			String delsql = "DELETE cm "
 					+ "FROM clothes_mark cm "
 					+ "INNER JOIN clothes c ON cm.clothes_id = c.clothes_id "
 					+ "WHERE c.clothes_id = ? AND c.user_id = ?;";
 			PreparedStatement pStmt2 = conn.prepareStatement(delsql);
 			
 			pStmt2.setInt(1, clothes.getClothes_id());
 			pStmt2.setInt(2, clothes.getUser_id());
			
 			// SQL文を実行する
 			pStmt2.executeUpdate();
 			
 			// clothes_mark テーブルにINSERT（洗濯表示）
            if (washingMarkIds != null && !washingMarkIds.isEmpty()) {
                String marksql = "INSERT INTO clothes_mark (clothes_id, washing_mark_id) VALUES (?, ?)";
                String checksql = "SELECT user_id FROM clothes WHERE clothes_id = ?";
                PreparedStatement pStmt3 = conn.prepareStatement(marksql);
                PreparedStatement pStmt4 = conn.prepareStatement(checksql);
                
                pStmt4.setInt(1, clothes.getClothes_id());
                
                ResultSet rs = pStmt4.executeQuery();
                
                if(rs.next()) {
                	int checkUser = rs.getInt("user_id");
                	if (checkUser == clothes.getUser_id()) {
		                for (Integer markId : washingMarkIds) {
		                    pStmt3.setInt(1, clothes.getClothes_id());
		                    pStmt3.setInt(2, markId);
		                    pStmt3.addBatch();
		                }
		                pStmt3.executeBatch();
		                pStmt3.close();
                	}
	            }
            }
            
            if (updateclCount == 1) {
            	String logsql = "INSERT INTO log(log_id, log_info, user_id, created_at) VALUES (0, ?, ?, NOW())";
				PreparedStatement pStmt3 = conn.prepareStatement(logsql);
				
				pStmt3.setString(1, "洗濯物が更新されました");
				pStmt3.setInt(2, clothes.getUser_id());
				int logCount = pStmt3.executeUpdate();
				
				if (logCount == 1) {
					conn.commit();
					result = true;
				} else {
					conn.rollback();
				}
            }	else {
            	conn.rollback();
            }
 			
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
