package prog3060.jwong.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.Bean.AgeGroupDetailsBeanLocal;
import prog3060.jwong.Bean.PopulationGrowthBeanLocal;

/**
 * Servlet implementation class AgeGroupDetailsServlet
 */
@WebServlet("/AgeGroupDetailsServlet")
public class AgeGroupDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AgeGroupDetailsBeanLocal AgeGroupDetailsBeanLocalInterface;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgeGroupDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ageGroupId = (String) request.getParameter("ageGroupID");
		String output = AgeGroupDetailsBeanLocalInterface.SpecificAgeGroupData(9);
		
		request.setAttribute("output", output);	
		request.getRequestDispatcher("/AgeGroupDetails.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
