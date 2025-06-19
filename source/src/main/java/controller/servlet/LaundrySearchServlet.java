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

import models.dao.ClothesDAO;
import models.dto.Clothes;

/**
 * Servlet implementation class LaundrySearchServlet
 */
@WebServlet("/LaundrySearchServlet")
public class LaundrySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらトップサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/servlet/TopServlet");
			return;
		}

		// 洗濯物一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらトップサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/servlet/TopServlet");
			return;
		}
		
		/* セッションスコープ保持しているユーザーIDをint型へ変換 */
		int user_id = (int) session.getAttribute("user_id");

		/* クローズDAOのインスタンスを生成 */
		ClothesDAO dao = new ClothesDAO();
		List<Clothes> favoriteList = dao.FavoriteSearch(user_id);

		// リクエストスコープに保存
		request.setAttribute("clothesList", favoriteList);

		// 洗濯表示一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry.jsp");
		dispatcher.forward(request, response);
	}

}
