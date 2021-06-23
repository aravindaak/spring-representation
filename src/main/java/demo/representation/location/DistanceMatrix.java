package demo.representation.location;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DistanceMatrix {
	private List<String> locations;
	private Map<String, Boolean> options;
	
	public DistanceMatrix() {
		
	}
	
	public DistanceMatrix(List<String> locations, Map<String, Boolean> options) {
		this.setLocations(locations);
		this.setOptions(options);
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public Map<String, Boolean> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Boolean> options) {
		this.options = options;
	}
}
