package prog3060.jwong.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.CanadaCensusDB.Household;

/**
 * Servlet implementation class NewHouseholdServlet
 */
@WebServlet("/NewHouseholdServlet")
public class NewHouseholdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewHouseholdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/AddHousehold.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		String geographicArea = (String) request.getParameter("geographicArea");
		String censusYear = (String) request.getParameter("censusYear");
		String householdType = (String) request.getParameter("householdType");
		String householdSize = (String) request.getParameter("householdSize");
		String householdByAgeRange = (String) request.getParameter("householdByAgeRange");
		String householdEarners = (String) request.getParameter("householdEarners");
		String totalIncome = (String) request.getParameter("totalIncome");
		String numberReported = (String) request.getParameter("numberReported");
		
		Household newHousehold = new Household();
		newHousehold.setId(Integer.parseInt(id));
//		newHousehold.setGeographicArea(geographicArea); // geo object
//		newHousehold.setCensusYear(censusYear); //censusyear obj
//		newHousehold.setHouseholdType(householdType); // householdType obj
//		newHousehold.setHouseholdSize(householdSize); //householdSize obj
//		newHousehold.setHouseholdsByAgeRange(householdsByAgeRange); //householdByagerange obj
//		newHousehold.setHouseholdEarners(householdEarners); // householdEarners obj
//		newHousehold.setTotalIncome(totalIncome); //totalIncome obj
		newHousehold.setNumberReported(Integer.parseInt(numberReported));
		
		request.getRequestDispatcher("/GeoDetails.jsp").forward(request, response);
		
		doGet(request, response);
	}

}
