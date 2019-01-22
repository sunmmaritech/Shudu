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
 * Servlet implementation class GetSolutionServlet
 */
@WebServlet("/GetSolutionServlet")
public class GetSolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSolutionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] mapStr = request.getParameterValues("mapij");
		ShuduService sds = new ShuduService();
		HttpSession session = request.getSession();
		int[][] mapOrigin = (int[][])session.getAttribute("mapOrigin");
		int[][] map = new int[9][9];
		int[][] record = new int[9][9];
		int i = 0;
		int j = 0;
		int mapNum = 0;
		for(int m = 0; m < 81; m++) {
			i = m / 9;
			j = m % 9;
			if(mapOrigin[i][j] != 0) {
				record[i][j] = 1;
			}else {
				record[i][j] = 2;
			}
			if(mapStr[m] == null || "".equals(mapStr[m]) ) {
				map[i][j] = 0;
			}else {
				mapNum = Integer.parseInt(mapStr[m]);	
				if(mapNum <= 9 && mapNum >= 1) {
					map[i][j] = mapNum;
				}else {
					map[i][j] = 0;
				}
			}
		}
		long startTime = System.currentTimeMillis();
		boolean flag = sds.getSolution(map);
		
		long endTime = System.currentTimeMillis();
		long completeTime = endTime-startTime;
		if(flag == true) {
			request.setAttribute("map", map);
			request.setAttribute("complete", 1);
			request.setAttribute("completeTime", completeTime);
		}else {		
			request.setAttribute("msg", "�޽�,��������");
			request.setAttribute("map", mapOrigin);
		}
		request.setAttribute("record", record);
		request.getRequestDispatcher("puzzle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
