package project.controller;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.domain.*;
import project.domain.Person;
import project.domain.PersonService;
import project.domain.Student;
import project.domain.User;

@Controller
public class HelloReaderController {
	
private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	 
	private static final String[] countries = { "Turkey", "United States", "Germany" };

    @RequestMapping(value = "/hello")
    public ModelAndView sayHello() {
    	ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello Reader!");
        mv.setViewName("helloReader");
        return mv;
    }
    
    @RequestMapping(value="/options")
    public ModelAndView showOptions() {
    	ModelAndView mv = new ModelAndView();
         mv.setViewName("options");
        return mv;
    }
 
    @RequestMapping( value="/form" )  
    public ModelAndView user() {
    	ModelAndView modelAndView = new ModelAndView("userForm", "user", new User()) ; 
    	modelAndView.addObject("countries", countries) ; 
    	modelAndView.addObject("genders", Gender.values()) ; 
    	return modelAndView ; 
    }

    @RequestMapping( value="/result" )
    public ModelAndView processUser(User user) {
    	ModelAndView modelAndView = new ModelAndView() ; 
    	modelAndView.setViewName("userResult");
    	modelAndView.addObject("u", user ) ; 
    	return modelAndView ; 
    }
    
    @RequestMapping(value="/jpaAdd" )
    public ModelAndView jpaHibernateCrudMySQL() {
    	// set all the hibernate class configuration
    	ModelAndView mv = new ModelAndView("jpaCRUD","person",new Person());
        return mv;  	
     }
    
    @RequestMapping(value="/insert")
    public ModelAndView insertPerson(Person person) {
    	personService.insert(person);    	
		return new ModelAndView("options");   	
    }
    
    
    
    @RequestMapping(value="/delete")
    public ModelAndView deletePerson(Long id) {
     	personService.delete(id);    	
		return new ModelAndView("options");
    }
    
    @RequestMapping(value="/readAll")
    public ModelAndView readAll() {   	
    	// forward request to persons list  UI 
    			ModelAndView mv = new ModelAndView();
    	    	mv.addObject("persons",personService.readAll()) ; 
    	        mv.setViewName("jpaRUD");
    	        return mv;  
    }
    
    @RequestMapping(value="/update")
    public ModelAndView update(Long id) {    	
        return new ModelAndView("jpaUpdate","person",personService.read(id)); 	
    }
    
    @RequestMapping(value="/doUpdate" )
    public ModelAndView doUpdate( Person person)
    {   	
    	 personService.update(person);    	
      	 return new ModelAndView("options"); 
    }
    
    
    
    @RequestMapping(value="/jpaHibernateResult")
    public ModelAndView jpaHibernateShow(Person person) {
    	// set all the hibernate class configuration
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Config.class);
		
		EntityManagerFactory entityManagerFactory = applicationContext
				.getBean(EntityManagerFactory.class);
		
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(person);		
		
		
		// now get all the lists of person 
		List<Person> persons =  entityManager.createQuery("from Person", Person.class).getResultList() ; 
 		
		transaction.commit();
		entityManager.close();
   	
		for(Person p : persons)
			System.out.println(p.getFirstName());
		
		// forward request to persons list  UI 
		ModelAndView mv = new ModelAndView();
    	mv.addObject("persons",persons) ; 
        mv.setViewName("jpaRUD");
        return mv;  	
     }
    
    public ModelAndView getLists() {
    	return null ; 
    }
    
}

