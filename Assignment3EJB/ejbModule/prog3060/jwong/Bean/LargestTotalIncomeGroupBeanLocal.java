package prog3060.jwong.Bean;

import javax.ejb.Local;

import prog3060.jwong.CanadaCensusDB.CensusYear;
import prog3060.jwong.CanadaCensusDB.GeographicArea;

@Local
public interface LargestTotalIncomeGroupBeanLocal {
	 public String LargestTotalIncomeGroup(GeographicArea geoArea, CensusYear censusYear);
}
