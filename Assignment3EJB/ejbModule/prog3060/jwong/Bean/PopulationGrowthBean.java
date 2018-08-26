package prog3060.jwong.Bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import prog3060.jwong.CanadaCensusDB.AgeGroup;

/**
 * Session Bean implementation class PopulationGrowthBean
 */
@Stateless
@LocalBean
public class PopulationGrowthBean implements PopulationGrowthBeanLocal {

    /**
     * Default constructor. 
     */
    public PopulationGrowthBean() {
         
    }
    
    static final String PERSISTENCE_UNIT_NAME = "Assignment2JPAApplication";
	List<AgeGroup> ageGroupList;
    
    public List<AgeGroup> getAgeGroupList() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM AgeGroup";

			Query baseQuery = tempEntityManager.createQuery(query);

			this.ageGroupList = baseQuery.getResultList();

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

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
		return this.ageGroupList;
	}

}
