package prog3060.jwong.Bean;

import java.util.List;

import javax.ejb.Local;

import prog3060.jwong.CanadaCensusDB.Age;
import prog3060.jwong.CanadaCensusDB.AgeGroup;

@Local
public interface PopulationGrowthBeanLocal {
	public List<AgeGroup> getAgeGroupList();
}
