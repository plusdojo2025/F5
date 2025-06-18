package test;

import java.util.List;

import models.dao.akamineTest;
import models.dto.Clothes;

public class test {

	/* ユーザーが所持している洗濯物の中でお気に入りを表示*/
	public static void showAllData(List<Clothes> clothesList) {
		for (Clothes clothes : clothesList) {
			System.out.println("洗濯物ID：" + clothes.getClothes_id());
			System.out.println("洗濯物画像：" + clothes.getClothes_img());
			System.out.println("カテゴリーID：" + clothes.getCategory_id());
			System.out.println("洗い方メモ：" + clothes.getRemarks());
			System.out.println("ユーザーID：" + clothes.getUser_id());
			System.out.println("お気に入り：" + clothes.getFavorite());
			System.out.println("登録日：" + clothes.getCreated_at());
			System.out.println("更新日：" + clothes.getUpdated_at());

			System.out.println();
		}
	}

	public static void main(String[] args) {
		akamineTest dao = new akamineTest();

		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<Clothes> clothesList = dao.FavoriteSearch(1);
        showAllData(clothesList);

	}

}
