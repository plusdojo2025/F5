package test;

import java.util.List;

import models.dao.CategoryDAO;
import models.dto.Category;

public class CategoryDAOTest {
	
	/* catList の中にある各カテゴリー名を取り出して表示 */
	public static void showAllData(List<Category> catALL) {
		for (Category catList : catALL) {
			System.out.println("洗濯物カテゴリーID：" + catList.getCategory_id());
			System.out.println("洗濯物カテゴリー名：" + catList.getCategory_name());

			System.out.println();
		}
	}

	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();

		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<Category> catListSel1 = dao.getAllCategories(new Category(0, ""));
		CategoryDAOTest.showAllData(catListSel1);

	}

}
