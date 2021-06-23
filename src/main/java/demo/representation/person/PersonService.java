package demo.representation.person;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	private final PersonRepo personRepo;
	
	@Autowired
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	public List<Person> getPerson() {
		return personRepo.findAll();
	}
	public Optional<Person> getPerson(String id) {
		return personRepo.findById(id);
	}
	public Person savePerson() {
		return personRepo.insert(new Person("Person1", List.of("Denver, CO","Westminster, CO","Boulder, CO")));
	}
	
}
