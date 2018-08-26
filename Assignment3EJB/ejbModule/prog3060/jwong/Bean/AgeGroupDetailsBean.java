package prog3060.jwong.Bean;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import prog3060.jwong.CanadaCensusDB.Age;
import prog3060.jwong.CanadaCensusDB.AgeGroup;
import prog3060.jwong.CanadaCensusDB.GeographicArea;

/**
 * Session Bean implementation class AgeGroupDetailsBean
 */
@Stateless
@LocalBean
public class AgeGroupDetailsBean implements AgeGroupDetailsBeanLocal {
	/**
	 * Default constructor.
	 */
	public AgeGroupDetailsBean() {
		// TODO Auto-generated constructor stub
	}
	EntityManagerFactory tempEntityManagerFactory = null;
	EntityManager tempEntityManager = null;
	static final String PERSISTENCE_UNIT_NAME = "Assignment2JPAApplication";

	public String SpecificAgeGroupData(int ageGroupId) {
		
		try {

			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            tempEntityManager = tempEntityManagerFactory.createEntityManager();

            tempEntityManager.getTransaction().begin();            

            String tempSelectJPQLQuery = "SELECT a1, a2, c1, c2, ag1, ag2, geo1, geo2, "
            		+ "(CAST((a1.combined - a2.combined)AS float)/CAST(a2.combined AS float)) AS increase "
            		+ "FROM Age a1, Age a2 "
            		+ "JOIN a1.ageGroup ag1 "
            		+ "JOIN a2.ageGroup ag2 "
            		+ "JOIN a1.censusYear c1 "
            		+ "JOIN a2.censusYear c2 "
            		+ "JOIN a1.geographicArea geo1 "
            		+ "JOIN a2.geographicArea geo2 "
            		+ "WHERE a2.combined > 0 "
            		+ "AND ag1.ageGroupID=ag2.ageGroupID "
            		+ "AND c1.censusYear = 2016 "
            		+ "AND c2.censusYear = 2011 "
            		+ "AND geo1.geographicAreaID=geo2.geographicAreaID "
            		+ "AND ag1.ageGroupID=:AgeGroup "
            		+ "ORDER BY increase DESC";

			Query tempQuery = tempEntityManager.createQuery(tempSelectJPQLQuery).setParameter("AgeGroup", 9).setMaxResults(1);
			List<Object[]> tempResultList = tempQuery.getResultList();

			Iterator<Object[]> tempAgeIterator = tempResultList.iterator();

			while (tempAgeIterator.hasNext()) {
				Object[] tempResultSet = tempAgeIterator.next();
				Age age1 = (Age) tempResultSet[0];
				Age age2 = (Age) tempResultSet[1];

				AgeGroup ageGroup = (AgeGroup) tempResultSet[4];
				GeographicArea Geo = (GeographicArea) tempResultSet[6];
				Float increase = (Float) tempResultSet[8] * 100;
//				System.out.println(Geo.getName()
//						+ " had  the  largest  population  growth  for  the age group described by "
//						+ ageGroup.getDescription() + ".  In 2011 the total population was " + age2.getCombined()
//						+ " and in 2016, the total population was " + age1.getCombined()
//						+ ".  This represents a population in-crease of " + String.format("%.1f", increase) + "%.");
				
				return "Geo.getName()+\" had  the  largest  population  growth  for  the age group described by \"+ageGroup.getDescription()+\".  In 2011 the total population was \""
						+ "+age2.getCombined()+\" and in 2016, the total population was \"+age1.getCombined()+\".  This represents a population in-crease of \"+String.format(\"%.1f\", increase)+\"%.\"";
			}

			tempEntityManager.getTransaction().rollback();
		} catch (Exception e) {
			tempEntityManager.getTransaction().rollback();
			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return "";
	}

}
