package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.dao.UsersDAO;
import models.dto.Users;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	 * 		response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users/user_regist.jsp");
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
		String nickname  = request.getParameter("nickname");
		String email  = request.getParameter("email");
		String password = request.getParameter("password");
		String password_check = request.getParameter("password_check");
		
		// パスワード確認
	    if (!password.equals(password_check)) {
	        request.setAttribute("error", "パスワードが一致しません。");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users/user_regist.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }
		
		// 登録処理を行う
		UsersDAO dao = new UsersDAO();
		if (dao.insert(new Users(0, password, nickname, email, null, "", ""))) {
			response.sendRedirect("servlet/LoginServlet");; // 登録成功後、ログインページへリダイレクト
		} else { // 登録失敗
			request.setAttribute("error", "登録に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users/user_regist.jsp");
			dispatcher.forward(request, response);
		}
	
	}
}
