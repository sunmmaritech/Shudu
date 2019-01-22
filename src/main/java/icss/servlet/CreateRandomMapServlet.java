package icss.servlet;



import icss.service.ShuduService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CreateRandomMap
 */
@WebServlet("/CreateRandomMapServlet")
public class CreateRandomMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRandomMapServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShuduService sds = new ShuduService();
		int[][] map = sds.createRandomMap();
		request.setAttribute("map", map);
		request.setAttribute("complete", 1);
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
