package prog3060.jwong.Bean;

import javax.ejb.Local;

@Local
public interface AgeGroupDetailsBeanLocal {
	public String SpecificAgeGroupData(int ageGroupId);
}
