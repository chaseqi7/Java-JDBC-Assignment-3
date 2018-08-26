package prog3060.jwong.Bean;

import java.util.List;

import javax.ejb.Local;

import prog3060.jwong.CanadaCensusDB.GeographicArea;

@Local
public interface GeographicAreaListBeanLocal {
	public List<GeographicArea> getGeographicList();
}
