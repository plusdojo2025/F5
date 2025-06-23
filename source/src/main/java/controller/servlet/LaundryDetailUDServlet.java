package controller.servlet;

import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import models.dao.ClothesDAO;
import models.dao.Laundry_categoryDAO;
import models.dao.Washing_markDAO;
import models.dto.Clothes;
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
			response.sendRedirect("/F5/LoginServlet");
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
		
		// 登録ページにフォワードする
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
//		HttpSession session = request.getSession();
//		if (session.getAttribute("email") == null) {
//			response.sendRedirect("/webapp/LoginServlet");
//			return;
//		}
		
		String action = request.getParameter("action");
		ClothesDAO dao = new ClothesDAO();
		
		int userid = Integer.parseInt(request.getParameter("user_id"));
		int clothesid = Integer.parseInt(request.getParameter("clothes_id"));
		
		if ("update".equals(action)) {
			Clothes clothes  = new Clothes();
			clothes.setClothes_id(clothesid);
			clothes.setUser_id(userid);
			clothes.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			clothes.setRemarks("remarks");
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
				for (int i=0; i<markid.length; i++) {
					int value = Integer.parseInt(markid[i]);
					washingMarkIds.add(value);
				}
			}
			
			boolean success = dao.update(clothes,  washingMarkIds);
			if (success) {
				response.sendRedirect(request.getContextPath() + "/LaundryServlet");
			}
			
		}	else {
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
