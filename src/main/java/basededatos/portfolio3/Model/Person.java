package basededatos.portfolio3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String nombre;
   
    public Person() {}
    
    public Person(String _nombre) {
        nombre = _nombre;
    }
}
