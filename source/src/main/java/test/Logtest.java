package test;
import java.util.List;

import models.dao.LogDAO;
import models.dto.Log;
public class Logtest {
	//SQLにlogのデータを入れてから使ってね
	public static void ShowData(List<Log> LogList) {
		for(Log log : LogList) {
			System.out.println("ログID" + log.getLog_id());
			System.out.println("ログ情報" + log.getLog_info());
			System.out.println("ユーザーID" + log.getUser_id());
			System.out.println("登録日" + log.getCreated_at());
		}
	}
	
	public static void main(String[] args) {
		LogDAO dao = new LogDAO();
		//↓()に任意のユーザーidを入力してください。
		List<Log> test = dao.getLog(1);
		Logtest.ShowData(test);
		
	}
}
