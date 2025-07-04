package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.dao.ClothesDAO;
import models.dto.Clothes;

/**
 * Servlet implementation class Image_ClothesServlet
 */
@WebServlet("/Image_ClothesServlet")
public class Image_ClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // リクエストパラメータ「id」を取得（名刺の番号を指定）
        String id = request.getParameter("id");
        if (id == null) {
        	// numberパラメータがない場合は400エラー（Bad Request）を返す
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
     // numberパラメータをint型に変換
        int number = Integer.parseInt(id);
        // DAOを使って指定された番号の名刺データを取得
        ClothesDAO dao = new ClothesDAO();
        Clothes cl = dao.findByNumber(number); // numberで1件取得するメソッドを作る
        
     // 名刺が存在し、かつ画像データがある場合
        if (cl != null && cl.getClothes_img() != null) {
            response.setContentType("image/jpeg"); // 画像タイプに合わせて変更
         // 画像データをレスポンスの出力ストリームに書き込み、画像を返す
            response.getOutputStream().write(cl.getClothes_img());
        } else {
        	// データが見つからない、もしくは画像がない場合は404エラーを返すs
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
