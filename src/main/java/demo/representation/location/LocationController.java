package demo.representation.location;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/location")
public class LocationController {
	private final LocationService locationService;
	
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService=locationService;
	}
	
	@PostMapping(path="find")
	public DistanceMatrixResponse find(@RequestBody Map<String, Object> reqMap) {
		
		return locationService.find(reqMap.get("personId").toString(),reqMap.get("lastKnownLocation").toString(),(Integer)reqMap.get("timeElapsed"));
		
	}
}
