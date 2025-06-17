package test;

import java.util.List;

import models.dao.CategoryDAO;
import models.dto.Category;

public class CategoryDAOTest {
	
	/* catList の中にある各カテゴリー名を取り出して表示 */
	public static void showAllData(List<Category> categoryList) {
		for (Category category : categoryList) {
			System.out.println("洗濯物カテゴリーID：" + category.getCategory_id());
			System.out.println("洗濯物カテゴリー名：" + category.getCategory_name());

			System.out.println();
		}
	}

	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();

		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<Category> catListSel1 = dao.getAllCategories();
		CategoryDAOTest.showAllData(catListSel1);

	}

}
