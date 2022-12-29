package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import basededatos.portfolio3.Model.Admin;
import basededatos.portfolio3.Model.Person;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    List<Admin> findByPersona(Person persona);
    List<Admin> findByPersonaId(Long id);
    
}
