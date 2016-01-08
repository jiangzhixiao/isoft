package io.isoft.reg.domain.xml;

import io.isoft.reg.domain.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author jzx
 */
@XmlRootElement(name = "cities")
public class CityXml {
	private List<City> cities;

	public CityXml() {
	}

	public CityXml(List<City> cities) {
		this.cities = cities;
	}

	@XmlElement(name = "city")
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
