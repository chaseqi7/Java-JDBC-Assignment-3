package prog3060.jwong.Bean;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import prog3060.jwong.CanadaCensusDB.CensusYear;
import prog3060.jwong.CanadaCensusDB.GeographicArea;
import prog3060.jwong.CanadaCensusDB.Household;

/**
 * Session Bean implementation class LargestTotalIncomeGroupBean
 */
@Stateless
@LocalBean
public class LargestTotalIncomeGroupBean implements LargestTotalIncomeGroupBeanLocal {
	
	EntityManagerFactory tempEntityManagerFactory = null;
    EntityManager tempEntityManager = null;
	static final String PERSISTENCE_UNIT_NAME = "Assignment2JPAApplication";
	
    /**
     * Default constructor. 
     */
    public LargestTotalIncomeGroupBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String LargestTotalIncomeGroup(GeographicArea geoArea, CensusYear censusYear) {
    	

        try
        {

			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            tempEntityManager = tempEntityManagerFactory.createEntityManager();

            tempEntityManager.getTransaction().begin();            


            
            
            String tempSelectJPQLQuery = "FROM Household hh "
            		+ "JOIN hh.geographicArea ga "
            		+ "JOIN hh.censusYear cy "
            		+ "JOIN hh.householdType hht "
            		+ "JOIN hh.householdSize hhs "
            		+ "JOIN hh.householdEarners hhe "
            		+ "JOIN hh.householdsByAgeRange hhb "
            		+ "JOIN hh.totalIncome ti "
            		+ "WHERE ga.alternativeCode = :altCode "
            		+ "AND ti.id !=1 "
            		+ "AND ti.id !=22 "
            		+ "AND cy.censusYear=:censusYear "
            		+ "AND hht.id=7 "
            		+ "AND hhs.id=3 "
            		+ "AND hhe.id=3 "
            		+ "ORDER BY hh.numberReported DESC";
                        		
            Query tempQuery = tempEntityManager.createQuery(tempSelectJPQLQuery).setParameter("altCode", geoArea.getAlternativeCode()).setParameter("censusYear", censusYear.getCensusYear()).setMaxResults(1);
            List<Object[]> tempResultList = tempQuery.getResultList();
            
            String tti="";
            String number = "";
            Iterator <Object[]> tempResultListIterator = tempResultList.iterator();
            while (tempResultListIterator.hasNext())
            {
            	Object[] tempResultSet = tempResultListIterator.next();
            	Household tempRetrievedHousehold=(Household) tempResultSet[0];
            	tti = tempRetrievedHousehold.getTotalIncome().getDescription();
            	number = Integer.toString(tempRetrievedHousehold.getNumberReported());

            }          
            tempEntityManager.getTransaction().rollback();
            
            return "The  total  income  group  with  the  highest  number  of  households  reported  by "+geoArea.getName()+" in "+censusYear.getCensusYear()+" was the one described by "+tti+" with "+number+".";
            
        }
        catch (Exception e)
        {
        	tempEntityManager.getTransaction().rollback();
            if (tempEntityManager != null)
            {

                tempEntityManager.getTransaction().rollback();

            }

            e.printStackTrace();

        }
        finally
        {

            if (tempEntityManager != null)
            {

                tempEntityManager.close();

            }

            if (tempEntityManagerFactory != null)
            {

                tempEntityManagerFactory.close();

            }
        }    
    	return "";
    }

}
