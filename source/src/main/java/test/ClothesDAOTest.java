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
        System.out.println("---------- insert()のテスト ----------");

        // Clothesオブジェクトを作成
//        Clothes insRec = new Clothes(0, null, 2, "テスト", 1, true, null, null);
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
        
        // delete()のテスト
	    System.out.println("---------- delete()のテスト ----------");
	    Clothes clothesToDelete = new Clothes();
	    clothesToDelete.setClothes_id(11);  // 削除するclothes_id
        clothesToDelete.setUsers_id(2);   // 対象ユーザーのID

        // 削除処理を実行
        if (dao.delete(clothesToDelete)) {
            System.out.println("削除成功！");
        } else {
            System.out.println("削除失敗！");
        }
        
        // update()のテスト
        System.out.println("---------- update()のテスト ----------");

        // 更新するClothesオブジェクトを作成
        Clothes updateRec = new Clothes(11, null, 3, "更新テスト", 1, false, null, null);
        List<Integer> newWashingMarkIds = Arrays.asList(1, 3, 5);

        if (dao.update(updateRec, newWashingMarkIds)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失敗！");
        }
    }    
}

