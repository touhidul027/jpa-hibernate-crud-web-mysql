package project.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

//@Transactional - methods defined inside this class are transactional

@Transactional
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO ; 
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public void insert(Person person) {
		personDAO.insert(person);
	}

	@Override
	public void delete(Long id) {
		personDAO.delete(id) ; 
	}

	@Override
	public List<Person>  readAll() {
		return personDAO.readAll(); 
 	}

	@Override
	public Person read(Long id) {
 		 return personDAO.read(id);
	}

	@Override
	public void update(Person person) {
		personDAO.update(person);
	}

}
