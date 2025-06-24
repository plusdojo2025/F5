package controller.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import models.dao.ClothesDAO;
import models.dto.Clothes;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UpdateDeleteServlet")
public class UpdateDeleteServlet extends HttpServlet {
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

		// 洗濯物更新削除ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
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
		
		/* リクエストパラメータ（更新・削除）を取得 */
		String action = request.getParameter("action");
		ClothesDAO dao = new ClothesDAO();

		int userid = (int) session.getAttribute("user_id");
		int clothesid = Integer.parseInt(request.getParameter("clothes_id"));

		if ("更新".equals(action)) {
			Clothes clothes = new Clothes();
			clothes.setClothes_id(clothesid);
			clothes.setUser_id(userid);
			clothes.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			clothes.setRemarks(request.getParameter("remarks"));
			clothes.setFavorite(Boolean.parseBoolean(request.getParameter("favorite")));

			// 画像処理
			Part image_data = request.getPart("clothes_img");
			byte[] clothes_img = null;

			if (image_data != null && image_data.getSize() > 0) {
				try (InputStream inputStream = image_data.getInputStream()) {
					clothes_img = inputStream.readAllBytes();
				}
			}
			if (clothes_img == null) {
				clothes_img = getDefaultImage();
			}

			// 洗濯表示ID取得してwashingMarkIdsリストに格納
			String[] markid = request.getParameterValues("washing_mark");
			List<Integer> washingMarkIds = new ArrayList<>();
			if (markid != null) {
				for (int i = 0; i < markid.length; i++) {
					int value = Integer.parseInt(markid[i]);
					washingMarkIds.add(value);
				}
			}

			boolean success = dao.update(clothes, washingMarkIds);
			if (success) {
				response.sendRedirect(request.getContextPath() + "/LaundryServlet");
			}

		} else {
			Clothes clothes = new Clothes();
			clothes.setClothes_id(clothesid);
			clothes.setUser_id(userid);
			boolean success = dao.delete(clothes);
			if (success) {
				response.sendRedirect(request.getContextPath() + "/LaundryServlet");
			}
		}
	}

	private byte[] getDefaultImage() throws IOException {
		try (InputStream inputStream = getServletContext().getResourceAsStream("/img/clothes.png")) {
			if (inputStream == null) {
				throw new IOException("Default image not found");
			}
			return inputStream.readAllBytes();
		}

	}

}
