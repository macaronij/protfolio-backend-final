package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import basededatos.portfolio3.Model.Contact;
import basededatos.portfolio3.Model.Person;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    List<Contact> findByPersona(Person persona);
    List<Contact> findByPersonaId(Long id);
}
