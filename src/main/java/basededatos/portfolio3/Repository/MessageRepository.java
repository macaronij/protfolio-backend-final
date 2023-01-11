package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import basededatos.portfolio3.Model.Message;
import basededatos.portfolio3.Model.Person;

public interface MessageRepository extends CrudRepository<Message, Long>{
    List<Message> findByPersona(Person persona);
    // es para usar desde un controllador de java, no se puede buscar desde Data Rest directo, porque el parametro que es un objeto no puede pasarse por la barra de direcciones
    List<Message> findByPersonaId(Long id);
    // aca si podemos usarlo dentro de java o por data rest
    List<Message> findByPersonaNombre(String nombre);
    // Ejemplo Data Rest --> http://localhost:8080/api/educations/search/findByPersonaNombre?nombre=Fede
    
}
