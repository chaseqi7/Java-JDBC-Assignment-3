package prog3060.jwong.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.CanadaCensusDB.GeographicArea;

/**
 * Servlet implementation class NewGeographicAreaServlet
 */
@WebServlet("/NewGeographicAreaServlet")
public class NewGeographicAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGeographicAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/AddGeographicArea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String geographicAreaId = (String) request.getParameter("geographicAreaId");
		String code = (String) request.getParameter("code");
		String level = (String) request.getParameter("level");
		String name = (String) request.getParameter("name");
		String altCode = (String) request.getParameter("altCode");
		
		GeographicArea newGeoArea = new GeographicArea();
		newGeoArea.setGeographicAreaId(Integer.parseInt(geographicAreaId));
		newGeoArea.setCode(Integer.parseInt(code));
		newGeoArea.setLevel(Integer.parseInt(level));
		newGeoArea.setName(name);
		newGeoArea.setAlternativeCode(Integer.parseInt(altCode));
		
		
		request.getRequestDispatcher("/GeoDetails.jsp").forward(request, response);
		doGet(request, response);
	}

}
