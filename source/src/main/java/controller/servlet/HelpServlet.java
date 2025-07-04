package controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelpServlet
 */
@WebServlet("/HelpServlet")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトするつまり不正アクセス防止
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect(request.getContextPath() + "/TopServlet");
					return;
				}

		// リクエストディスパッチャオブジェクトを取得する
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/WEB-INF/jsp/help.jsp");
				// フォワードする
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
