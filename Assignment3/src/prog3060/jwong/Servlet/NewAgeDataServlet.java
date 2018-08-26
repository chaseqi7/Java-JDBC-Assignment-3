package prog3060.jwong.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.CanadaCensusDB.Age;

/**
 * Servlet implementation class NewAgeDataServlet
 */
@WebServlet("/NewAgeDataServlet")
public class NewAgeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAgeDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/AddAgeData.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ageId = (String) request.getParameter("ageId");
		String ageGroup = (String) request.getParameter("ageGroup");
		String censusYear = (String) request.getParameter("censusYear");
		String geographicArea = (String) request.getParameter("geographicArea");
		String combined = (String) request.getParameter("combined");
		String male = (String) request.getParameter("male");
		String female = (String) request.getParameter("female");
		
		Age newAge = new Age();
		newAge.setAgeID(Integer.parseInt(ageId));
//		newAge.setAgeGroup(Integer.parseInt(ageGroup)); // Age Group Object
//		newAge.setCensusYear(Integer.parseInt(censusYear)); // Census Year Object
//		newAge.setGeographicArea(geographicArea); // GeoArea Object
		newAge.setCombined(Integer.parseInt(combined));
		newAge.setMale(Integer.parseInt(male));
		newAge.setFemale(Integer.parseInt(female));
		
		
		
		
		request.getRequestDispatcher("/GeoDetails.jsp").forward(request, response);
		doGet(request, response);
	}

}
