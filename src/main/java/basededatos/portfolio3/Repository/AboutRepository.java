package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import basededatos.portfolio3.Model.About;
import basededatos.portfolio3.Model.Person;

public interface AboutRepository extends CrudRepository<About, Long>{
    List<About> findByPersona(Person persona);
    List<About> findByPersonaId(Long id);
    
}
