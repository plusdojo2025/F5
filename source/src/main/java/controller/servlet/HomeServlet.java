package controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dao.Laundry_categoryDAO;
import models.dao.LogDAO;
import models.dao.Washing_markDAO;
import models.dto.Laundry_category;
import models.dto.Log;
import models.dto.Washing_mark;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトするつまり不正アクセス防止
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect(request.getContextPath() + "/TopServlet");
					return;
				}

		//洗濯カテゴリー（漂白など）をデータベースから取得
		Laundry_categoryDAO lcdao = new Laundry_categoryDAO();
		List<Laundry_category> laundry_categoryList = lcdao.getLaundryCategory();
		request.setAttribute("laundry_categoryList", laundry_categoryList);
		
		//洗濯表示をデータベースから取得する。
		Washing_markDAO wdao = new Washing_markDAO();
		//Washing_markDAOのgetWashing_mark()を呼び出す。
		List<Washing_mark> Washing_markList = wdao.getWashing_mark();
		
		//洗濯マークををリクエストスコープに格納する
			request.setAttribute("Washing_markList", Washing_markList);
		
		//ログ情報をデータベースから取得する。
		LogDAO ldao = new LogDAO();
		//セッションに保存されているuser=idをもらう。
		Integer user_id = (Integer) session.getAttribute("user_id");
		
		List<Log> logList = ldao.getLog(user_id);
		//洗濯マークををリクエストスコープに格納する
			request.setAttribute("logList", logList);
		
		// リクエストディスパッチャオブジェクトを取得する
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		// フォワードする
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
