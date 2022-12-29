package basededatos.portfolio3.Repository;

import org.springframework.data.repository.CrudRepository;

import basededatos.portfolio3.Model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
    
}
