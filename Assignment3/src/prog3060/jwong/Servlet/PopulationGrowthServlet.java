package prog3060.jwong.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prog3060.jwong.Bean.PopulationGrowthBeanLocal;
import prog3060.jwong.CanadaCensusDB.AgeGroup;

/**
 * Servlet implementation class PopulationGrowthServlet
 */
@WebServlet("/PopulationGrowthServlet")
public class PopulationGrowthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	PopulationGrowthBeanLocal PopulationGrowthBeanLocalInterface;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulationGrowthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AgeGroup> ageGroupList = PopulationGrowthBeanLocalInterface.getAgeGroupList();
		
		request.setAttribute("ageGroupList", ageGroupList);		
		request.getRequestDispatcher("/AgeRanges.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
