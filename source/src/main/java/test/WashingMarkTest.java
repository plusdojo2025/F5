package test;
import java.util.List;

import models.dao.Washing_markDAO;
import models.dto.Washing_mark;

public class WashingMarkTest {
	public static void ShowData(List<Washing_mark> Washing_markList) {
		for(Washing_mark mark : Washing_markList) {
			System.out.println("洗濯マークID" + mark.getWashing_id());
			System.out.println("洗濯マークアイコン" + mark.getWashing_mark_icon());
			System.out.println("洗濯マーク情報" + mark.getWashing_mark_info());
			System.out.println("洗濯カテゴリー名前" + mark.getLaundry_category_name());
			System.out.println("図柄番号" + mark.getWashing_mark_number());
		}
		
	}

	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Washing_markDAO dao = new Washing_markDAO();
		List <Washing_mark> test = dao.getWashing_mark();
		WashingMarkTest.ShowData(test);

	}

}
