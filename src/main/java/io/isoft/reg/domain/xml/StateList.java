package io.isoft.reg.domain.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Roy Clarkson
 */
@XmlRootElement(name = "states")
public class StateList {
	private List<State> states;

	public StateList() {
	}

	public StateList(List<State> states) {
		this.states = states;
	}

	@XmlElement(name = "state")
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
}
