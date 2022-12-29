package basededatos.portfolio3.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import basededatos.portfolio3.Model.Education;
import basededatos.portfolio3.Model.Person;

public interface EducationRepository extends CrudRepository<Education, Long>{
    List<Education> findByPersona(Person persona);
    // es para usar desde un controllador de java, no se puede buscar desde Data Rest directo, porque el parametro que es un objeto no puede pasarse por la barra de direcciones
    List<Education> findByPersonaId(Long id);
    // aca si podemos usarlo dentro de java o por data rest
    List<Education> findByPersonaNombre(String nombre);
    // Ejemplo Data Rest --> http://localhost:8080/api/educations/search/findByPersonaNombre?nombre=Fede
    
}
