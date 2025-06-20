package test;

import java.util.Arrays;
import java.util.List;

import models.dao.ClothesDAO;
import models.dto.Clothes;

public class ClothesDAOTest {
    
    public static void showAllData(List<Clothes> clothesList) {
        for (Clothes clothes : clothesList) {
            System.out.println("洗濯物画像：" + clothes.getClothes_img());
            System.out.println("カテゴリーID：" + clothes.getCategory_id());
            System.out.println("備考：" + clothes.getRemarks());
            System.out.println("お気に入り：" + clothes.getFavorite());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ClothesDAO dao = new ClothesDAO();

        // insert()のテスト
//        System.out.println("---------- insert()のテスト ----------");
//
//        // Clothesオブジェクトを作成
//        Clothes insRec = new Clothes(0, null, 2, "テスト", 2, true, null, null);
//
//        // 洗濯表示のIDリスト（例：1, 3, 5 を設定）
//        List<Integer> washingMarkIds = Arrays.asList(1, 3, 5);
//
//        // insertメソッドに2つの引数を渡す
//        if (dao.insert(insRec, washingMarkIds)) {
//            System.out.println("登録成功！");
//        } else {
//            System.out.println("登録失敗！");
//        }
//        
//        // delete()のテスト
//	    System.out.println("---------- delete()のテスト ----------");
//	    Clothes clothesToDelete = new Clothes();
//	    clothesToDelete.setClothes_id(13);  // 削除するclothes_id
//        clothesToDelete.setUser_id(1);   // 対象ユーザーのID
//
//        // 削除処理を実行
//        if (dao.delete(clothesToDelete)) {
//            System.out.println("削除成功！");
//        } else {
//            System.out.println("削除失敗！");
//        }
//        
        // update()のテスト
        System.out.println("---------- update()のテスト ----------");

        // 更新するClothesオブジェクトを作成
        Clothes updateRec = new Clothes(13, null, 3, "更新テスト3", 2, false, null, null);
        List<Integer> newWashingMarkIds = Arrays.asList(1, 2);

        if (dao.update(updateRec, newWashingMarkIds)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失敗！");
        }
    }    
    
    /* ユーザーが所持している洗濯物を取得して表示 */
//	public static void showAllData(List<Clothes> clothesList) {
//		for (Clothes clothes : clothesList) {
//			System.out.println("洗濯物ID：" + clothes.getClothes_id());
//			System.out.println("洗濯物画像：" + clothes.getClothes_img());
//			System.out.println("カテゴリーID：" + clothes.getCategory_id());
//			System.out.println("洗い方メモ：" + clothes.getRemarks());
//			System.out.println("ユーザーID：" + clothes.getUser_id());
//			System.out.println("お気に入り：" + clothes.getFavorite());
//			System.out.println("登録日：" + clothes.getCreated_at());
//			System.out.println("更新日：" + clothes.getUpdated_at());
//
//			System.out.println();
//		}
//	}

//	public static void main(String[] args) {
//		ClothesDAO dao = new ClothesDAO();
//
//		// 全件表示
//		System.out.println("---------- select()のテスト1 ----------");
//		List<Clothes> clothesList = dao.getAllclothes(1);
//        showAllData(clothesList);
//
//        // お気に入りのみ表示
//		System.out.println("---------- select()のテスト1 ----------");
//		List<Clothes> clothesList = dao.FavoriteSearch(1);
//        showAllData(clothesList);
//
//
//	}
	
	/* ユーザーが所持している洗濯物の中で１つだけ洗濯し、更新と削除*/
//	public static void showAllData(List<JoinLandry> joinLandryList) {
//		for (JoinLandry joinLandry : joinLandryList) {
//		    System.out.println("ユーザーID" + joinLandry.getUser_id());
//		    System.out.println("洗濯物ID" + joinLandry.getClothes_id());
//		    System.out.println("洗濯物画像" + joinLandry.getClothes_img());
//		    System.out.println("洗い方メモ" + joinLandry.getRemarks());
//		    System.out.println("お気に入り" + joinLandry.getFavorite());
//		    System.out.println("登録日" + joinLandry.getCreated_at());
//		    System.out.println("更新日" + joinLandry.getUpdated_at());
//
//		    System.out.println("カテゴリーID" + joinLandry.getCategory_id());
//		    System.out.println("カテゴリー名" + joinLandry.getCategory_name());
//
//		    System.out.println("洗濯表示ID" + joinLandry.getWashing_mark_id());
//		    System.out.println("洗濯表示画像" + joinLandry.getWashing_mark_icon());
//		    System.out.println("図柄番号" + joinLandry.getWashing_mark_number());
//
//		    System.out.println("洗濯物カテゴリーID" + joinLandry.getLaundry_category_id());
//		    System.out.println("洗濯物カテゴリー名" + joinLandry.getLaundry_category_name());
//
//			System.out.println();
//		}
//	}
//
//	public static void main(String[] args) {
//		ClothesDAO dao = new ClothesDAO();
//
//		// select()のテスト1
//		System.out.println("---------- select()のテスト1 ----------");
//		List<JoinLandry> LaundryUDList = dao.GetLaundryUDSelect(1, 11);
//        showAllData(LaundryUDList);
//
//	}
}

