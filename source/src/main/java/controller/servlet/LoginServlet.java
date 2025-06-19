package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dao.LoginDAO;
import models.dao.UsersDAO;
import models.dto.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// ログイン処理を行う
		LoginDAO iDao = new LoginDAO();
		UsersDAO uDao = new UsersDAO();
		Users user = uDao.login_select(email);
		
		if (iDao.isLoginOK(new Users(0, password, "", email, null, "", ""))) { // ログイン成功
			// セッションスコープにメールアドレスを格納する
			HttpSession session = request.getSession();
			// session.setAttribute("id", new LoginUser(id));//
			int user_id = user.getUser_id();
			session.setAttribute("user_id", user_id);

			// ホームページにリダイレクトする
			response.sendRedirect("servlet/HomeServlet");
		} else { // ログイン失敗
			// リクエストスコープに、エラーメッセージを格納する
			request.setAttribute("error", "メールアドレスまたはパスワードが間違っています");
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}