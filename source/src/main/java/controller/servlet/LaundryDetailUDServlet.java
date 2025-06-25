package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dao.ClothesDAO;
import models.dao.Laundry_categoryDAO;
import models.dao.Washing_markDAO;
import models.dto.JoinLandry;
import models.dto.Laundry_category;
import models.dto.Washing_mark;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@MultipartConfig
@WebServlet("/LaundryDetailUDServlet")
public class LaundryDetailUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect(request.getContextPath() + "/TopServlet");
			return;
		}
		
		
		
		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry_detail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		// パラメータ取得
		request.setCharacterEncoding("UTF-8");
		int userid = Integer.parseInt(request.getParameter("user_id"));
		int clothesid = Integer.parseInt(request.getParameter("clothes_id"));
		
		// 登録情報を取得
		ClothesDAO dao = new ClothesDAO();
		List<JoinLandry> laundry = dao.GetLaundryUDSelect(userid, clothesid);
		// リクエストスコープに格納
		request.setAttribute("laundry", laundry);
		
		// JoinLandryのリストからwashing_mark_idを取得
		List<Integer> selectedMarkIds = new ArrayList<>();
		for (JoinLandry item : laundry) {
			if (item.getWashing_mark_id() != 0) {
				selectedMarkIds.add(item.getWashing_mark_id());
			}
		}
		request.setAttribute("selectedMarkIds", selectedMarkIds);
		
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry_detail.jsp");
		dispatcher.forward(request, response);
	}
}
