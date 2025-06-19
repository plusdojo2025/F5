package test;

import java.util.List;

import models.dao.akamineTest;
import models.dto.JoinLandry;

public class test {

	/* ユーザーが所持している洗濯物の中で１つだけ洗濯し、更新と削除*/
	public static void showAllData(List<JoinLandry> joinLandryList) {
		for (JoinLandry joinLandry : joinLandryList) {
		    System.out.println("ユーザーID" + joinLandry.getUser_id());
		    System.out.println("洗濯物ID" + joinLandry.getClothes_id());
		    System.out.println("洗濯物画像" + joinLandry.getClothes_img());
		    System.out.println("洗い方メモ" + joinLandry.getRemarks());
		    System.out.println("お気に入り" + joinLandry.getFavorite());
		    System.out.println("登録日" + joinLandry.getCreated_at());
		    System.out.println("更新日" + joinLandry.getUpdated_at());

		    System.out.println("カテゴリーID" + joinLandry.getCategory_id());
		    System.out.println("カテゴリー名" + joinLandry.getCategory_name());

		    System.out.println("洗濯表示ID" + joinLandry.getWashing_mark_id());
		    System.out.println("洗濯表示画像" + joinLandry.getWashing_mark_icon());
		    System.out.println("図柄番号" + joinLandry.getWashing_mark_number());

		    System.out.println("洗濯物カテゴリーID" + joinLandry.getLaundry_category_id());
		    System.out.println("洗濯物カテゴリー名" + joinLandry.getLaundry_category_name());

			System.out.println();
		}
	}

	public static void main(String[] args) {
		akamineTest dao = new akamineTest();

		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<JoinLandry> LaundryUDList = dao.GetLaundryUDSelect(1, 1);
        showAllData(LaundryUDList);

	}

}
