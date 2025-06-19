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
import javax.servlet.http.Part;

import models.dao.ClothesDAO;
import models.dto.Clothes;


@WebServlet("/LaundryRegistServlet")
public class LaundryRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("email") == null) {
//			response.sendRedirect("/webapp/LoginServlet");
//			return;
//		}
		
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users/laundry_regist.jsp");
		dispatcher.forward(request, response);
	}
	
	 /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("email") == null) {
//			response.sendRedirect("/webapp/LoginServlet");
//			return;
//		}
		
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
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		String remarks = request.getParameter("remarks");
		boolean favorite = Boolean.parseBoolean(request.getParameter("favorite"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		// リストに変換
		String para = request.getParameter("washing_mark");
		String[] washing_marks = (para != null) ? para.split(",") : new String[0];
		List<Integer> washingMarkIds = new ArrayList<>();
		for (int i=0; i<washing_marks.length; i++) {
			String markId = washing_marks[i].trim();
			washingMarkIds.add(Integer.parseInt(markId));
		}
		
		// 登録処理
		ClothesDAO dao = new ClothesDAO();
		dao.insert(new Clothes(0, clothes_img, category_id, remarks, user_id, favorite, null, null), washingMarkIds);
		
		// 同じ画面にリダイレクト
		response.sendRedirect(request.getContextPath() + request.getRequestURI());
		
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
