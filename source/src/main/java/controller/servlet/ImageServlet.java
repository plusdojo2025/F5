package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.dao.Washing_markDAO;
import models.dto.Washing_mark;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        Washing_markDAO dao = new Washing_markDAO();
        Washing_mark wm = dao.findByNumber(number); // numberで1件取得するメソッドを作る
        
     // 名刺が存在し、かつ画像データがある場合
        if (wm != null && wm.getWashing_mark_icon() != null) {
            response.setContentType("image/jpeg"); // 画像タイプに合わせて変更
         // 画像データをレスポンスの出力ストリームに書き込み、画像を返す
            response.getOutputStream().write(wm.getWashing_mark_icon());
        } else {
        	// データが見つからない、もしくは画像がない場合は404エラーを返すs
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}