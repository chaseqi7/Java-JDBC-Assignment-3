package prog3060.jwong.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.Bean.GeographicAreaListBeanLocal;
import prog3060.jwong.CanadaCensusDB.GeographicArea;
import prog3060.jwong.Servlet.*;

/**
 * Servlet implementation class GeographicAreasServlet
 */
@WebServlet("/GeographicAreasServlet")
public class GeographicAreasServlet extends HttpServlet {
	
	@EJB
	GeographicAreaListBeanLocal GeographicAreaListBeanLocalInterface;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeographicAreasServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GeographicArea> listGeo = GeographicAreaListBeanLocalInterface.getGeographicList();
		
		request.setAttribute("listGeo", listGeo);
		request.setAttribute("title", "List of Geographic Areas");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
