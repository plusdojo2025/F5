package test;
import java.util.List;

import models.dao.Laundry_categoryDAO;
import models.dto.Laundry_category;
public class Laundry_categorytest{
	public static void showData (List<Laundry_category> laundry_categoryList) {
		for (Laundry_category category : laundry_categoryList) {
	        System.out.println("洗濯カテゴリーID" + category.getLaundry_category_id());
	        System.out.println("洗濯カテゴリー名" + category.getLaundry_category_name());
	    }
	}
	public static void main(String[] args) {
		Laundry_categoryDAO dao = new Laundry_categoryDAO();
		List<Laundry_category> test = dao.getLaundryCategory();
		Laundry_categorytest.showData(test);
	}
}