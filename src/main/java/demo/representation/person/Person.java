package demo.representation.person;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Person {
	@Id
	private String id;
	private String name;
	private List<String> knownLocations;
	
	public Person(String id, String name, List<String> knownLocations) {
		this.setId(id); this.setName(name); this.setKnownLocations(knownLocations);
	}
	public Person(String name, List<String> knownLocations) {
		this.setName(name); this.setKnownLocations(knownLocations);
	}
	public Person() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getKnownLocations() {
		return knownLocations;
	}
	public void setKnownLocations(List<String> knownLocations) {
		this.knownLocations = knownLocations;
	}
}
