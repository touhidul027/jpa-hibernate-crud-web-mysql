package project.domain;

import java.util.List;

public interface PersonDAO {
	public void insert(Person person) ; 
	public void delete(Long id) ; 
	public List<Person>  readAll() ; 
	public Person read(Long id) ;
	public void update(Person person) ; 
}
