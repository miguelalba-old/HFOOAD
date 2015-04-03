package ch5.cohesive;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {

	private Map<String, Object> properties;

	public InstrumentSpec(Map<String, Object> properties) {
		if (properties == null) {
			this.properties = new HashMap<>();
		} else {
			this.properties = new HashMap<>(properties);
		}
	}

	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public boolean matches(InstrumentSpec otherSpec) {
		for (Map.Entry<String, Object> entry : otherSpec.properties.entrySet()) {
			if (!properties.get(entry.getKey()).equals(entry.getValue())) {
				return false;
			}
		}
		return true;
	}
}