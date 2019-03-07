package project.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PersonDAOImpl implements PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Person person) {
		// inserting into in database code will go here
		entityManager.persist(person);
	}
	
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Person.class, id));
	}

	@Override
	public List<Person> readAll() {
	 // now get all the lists of person 
	  return entityManager.createQuery("from Person", Person.class).getResultList() ; 
	}

	@Override
	public Person read(Long id) {		
 		return entityManager.find(Person.class, id) ; 
	}

	@Override
	public void update(Person person) {
		entityManager.merge(person) ; 
		entityManager.flush();
	}

	
	
	
}
