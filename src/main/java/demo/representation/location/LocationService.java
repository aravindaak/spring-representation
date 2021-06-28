package demo.representation.location;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.representation.person.Person;
import demo.representation.person.PersonService;


@Service
public class LocationService {
	
	private PersonService personService;
	
	@Autowired
	public LocationService(PersonService personService) {
		this.personService= personService;
	}
	
	public DistanceMatrixResponse find(String personId, String lastKnownLocation, Integer timeElapsed) {
		Optional<Person> optionalPerson = personService.getPerson(personId);
		Person person = optionalPerson.get();
		
		List<String> locationList = person.getKnownLocations();
		locationList.add(0, lastKnownLocation);
		DistanceMatrixResponse distanceResp = getDistanceMatrix(locationList);
		
		List<Integer> timeList =distanceResp.getTime().get(0);
		
		List<String> tempList =  distanceResp.getPossibleLocations();
		
		
		for(int i=0; i< timeList.size(); i++) {
			if(timeList.get(i) < timeElapsed) {
				
				tempList.add(locationList.get(i));
			}
		}
		distanceResp.setPossibleLocations(tempList);
		return distanceResp;
	}
	
	public DistanceMatrixResponse find(String personId, String lastKnownLocation, Integer timeElapsed, String nodesToConsider) {
		Optional<Person> optionalPerson = personService.getPerson(personId);
		Person person = optionalPerson.get();
		List<String> locationList = person.getKnownLocations();
		//Setting the lastKnownLocn as the first element		
		locationList.add(0, lastKnownLocation);
		DistanceMatrixResponse distanceResp = getDistanceMatrix(locationList);
		List<List<Integer>> timeList =distanceResp.getTime();
		System.out.println(timeList);
		ArrayList<ArrayList<String>> traversedPath= new ArrayList<>();
		for(int i=1; i< locationList.size(); i++) {
			int timeSum = timeList.get(0).get(i);
			for(int j =1; j< locationList.size(); j++) {
				if((i!=j) && timeSum+timeList.get(i).get(j) < timeElapsed) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(locationList.get(0));
					temp.add(locationList.get(i));
					temp.add(locationList.get(j));
					traversedPath.add(temp);
				}
					
			}
		}
		distanceResp.setTraversedPath(traversedPath);
		return distanceResp;
	}
	
	
	public DistanceMatrixResponse getDistanceMatrix(List<String> knownLocations) {
		
		DistanceMatrix distanceMatrix = new DistanceMatrix(knownLocations, Map.of("allToAll", true));
				
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://www.mapquestapi.com/directions/v2/routematrix?" + "key=y6lAlQDCKXjtCma0vhy0cUcJLA6DLpM0";
		DistanceMatrixResponse distanceResponseObj= restTemplate.postForObject(uri, distanceMatrix, DistanceMatrixResponse.class);
		
		
		return distanceResponseObj;
	}

	
	

}
