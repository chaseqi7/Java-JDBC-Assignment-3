package prog3060.jwong.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.Bean.LargestTotalIncomeGroupBeanLocal;
import prog3060.jwong.CanadaCensusDB.CensusYear;
import prog3060.jwong.CanadaCensusDB.GeographicArea;

/**
 * Servlet implementation class GeographicDetailsServlet
 */
@WebServlet("/GeographicDetailsServlet")
public class GeographicDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	LargestTotalIncomeGroupBeanLocal LargestTotalIncomeGroupBeanLocalInterface;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeographicDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String geoAreaId = (String) request.getParameter("geographicAreaId");
		String code = (String) request.getParameter("code");		
		String level = (String) request.getParameter("level");
		String name = (String) request.getParameter("name");
		String altCode = (String) request.getParameter("alternativeCode");
		
		GeographicArea existingGeoArea = new GeographicArea();
		existingGeoArea.setGeographicAreaId(Integer.parseInt(geoAreaId));
		existingGeoArea.setCode(Integer.parseInt(code));
		existingGeoArea.setLevel(Integer.parseInt(level));
		existingGeoArea.setName(name);
		existingGeoArea.setAlternativeCode(Integer.parseInt(altCode));
		
		CensusYear censusYear2016 = new CensusYear();
		censusYear2016.setCensusYearID(1);
		censusYear2016.setCensusYear(2016);
		
		CensusYear censusYear2011 = new CensusYear();
		censusYear2011.setCensusYearID(2);
		censusYear2011.setCensusYear(2011);
		
		
		String output2016 = LargestTotalIncomeGroupBeanLocalInterface.LargestTotalIncomeGroup(existingGeoArea, censusYear2016);
		String output2011 = LargestTotalIncomeGroupBeanLocalInterface.LargestTotalIncomeGroup(existingGeoArea, censusYear2011);
						
		request.setAttribute("geoAreaId", geoAreaId);
		request.setAttribute("code", code);
		request.setAttribute("level", level);
		request.setAttribute("name", name);
		request.setAttribute("altCode", altCode);
		
		request.setAttribute("output2016", output2016);
		request.setAttribute("output2011", output2011);
		request.getRequestDispatcher("/GeoDetails.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
