package demo.representation.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/v1/person")
public class PersonController {
	
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@GetMapping(path = "get")
	public List<Person> getPerson() {
		return personService.getPerson();
	}
	@PostMapping(path = "get")
	public Optional<Person> getPerson(String id) {
		return personService.getPerson(id);
	}

	@GetMapping(path= "save")
	public Person savePerson() {
		return personService.savePerson();
	}

}
