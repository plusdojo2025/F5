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
import models.dto.JoinLandry;

/**
 * Servlet implementation class LaundryDetailServlet
 */
@WebServlet("/LaundryDetailServlet")
public class LaundryDetailServlet extends HttpServlet {
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

		// 洗濯物詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry_detail.jsp");
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
		
		// リクエストパラメータから洗濯物IDを取得する
		request.setCharacterEncoding("UTF-8");
		int clothes_id = Integer.parseInt(request.getParameter("clothes_id"));

		/* セッションスコープ保持しているユーザーIDをint型へ変換 */
		int user_id = (int) session.getAttribute("user_id");

		ClothesDAO dao = new ClothesDAO();
		List<JoinLandry> LaundryUDList = dao.GetLaundryUDSelect(user_id, clothes_id);

		// リクエストスコープに保存
		request.setAttribute("LaundryUDList", LaundryUDList);

		// 洗濯物詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/laundry_detail.jsp");
		dispatcher.forward(request, response);
	}

}
