package demo.representation.location;

import java.util.ArrayList;
import java.util.List;

public class DistanceMatrixResponse {
	private List<List<String>> distance;
	private List<List<Integer>> time;
	private ArrayList<String> possibleLocations;
	private ArrayList<ArrayList<String>> traversedPath;
	
	public DistanceMatrixResponse() {
	}
	
	public DistanceMatrixResponse(List<List<String>> distance, List<List<Integer>> time, ArrayList<String> possibleLocations) {
		setDistance(distance);setTime(time); setPossibleLocations(possibleLocations);
	}
	
	public List<List<String>> getDistance() {
		return distance;
	}
	public void setDistance(List<List<String>> distance) {
		this.distance = distance;
	}
	public List<List<Integer>> getTime() {
		return time;
	}
	public void setTime(List<List<Integer>> time) {
		this.time = time;
	}

	public ArrayList<ArrayList<String>> getTraversedPath() {
		return traversedPath;
	}

	public void setTraversedPath(ArrayList<ArrayList<String>> traversedPath) {
		this.traversedPath = traversedPath;
	}

	public ArrayList<String> getPossibleLocations() {
		return possibleLocations;
	}

	public void setPossibleLocations(ArrayList<String> possibleLocations) {
		this.possibleLocations = possibleLocations;
	}
}
