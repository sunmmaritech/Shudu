package icss.servlet;


import icss.service.ShuduService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class SaveMapInSessionServlet
 */
@WebServlet("/SaveMapInSessionServlet")
public class SaveMapInSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMapInSessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[][] map = (int[][])request.getAttribute("map");
		ShuduService sds = new ShuduService();
		HttpSession session = request.getSession();
		int[][] mapOrigin = sds.copyMap(map);
		session.setAttribute("mapOrigin", mapOrigin);
		request.getRequestDispatcher("puzzle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
