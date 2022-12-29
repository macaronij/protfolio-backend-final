package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import basededatos.portfolio3.Model.Person;
import basededatos.portfolio3.Model.Proyect;

public interface ProyectRepository extends CrudRepository<Proyect, Long>{
    List<Proyect> findByPersona(Person persona);
    List<Proyect> findByPersonaId(Long id);
}
