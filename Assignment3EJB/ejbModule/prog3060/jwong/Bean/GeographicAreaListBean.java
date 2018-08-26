package prog3060.jwong.Bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import prog3060.jwong.CanadaCensusDB.*;

/**
 * Session Bean implementation class GeographicAreaListBean
 */
@Stateless
@LocalBean
public class GeographicAreaListBean implements GeographicAreaListBeanLocal {

    /**
     * Default constructor. 
     */
    public GeographicAreaListBean() {

    }
    
    static final String PERSISTENCE_UNIT_NAME = "Assignment2JPAApplication";
	List<GeographicArea> geographicList;
    
    public List<GeographicArea> getGeographicList() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM GeographicArea";

			Query baseQuery = tempEntityManager.createQuery(query);

			this.geographicList = baseQuery.getResultList();

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
		return this.geographicList;
	}

}
