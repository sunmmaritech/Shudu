package icss.servlet;


import icss.service.ShuduService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CreateNewMapServlet
 */
@WebServlet("/CreateNewMapServlet")
public class CreateNewMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewMapServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShuduService sds = new ShuduService();
		int[][] map = sds.createRandomMap();
		long startTime = System.currentTimeMillis();
		sds.createNewMap(map);
		System.out.println("success");
		long endTime = System.currentTimeMillis();
		long creatTime = endTime-startTime;
		sds.changeMapService(map);
		request.setAttribute("map", map);
		request.setAttribute("creatTime", creatTime);
//		request.getRequestDispatcher("puzzle.jsp").forward(request, response);
		request.getRequestDispatcher("SaveMapInSessionServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
