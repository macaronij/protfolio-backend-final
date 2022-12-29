package basededatos.portfolio3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    private Person persona;

    private Condicion condicion;

    public static enum Condicion {
        USER, ADMIN
    }

    public Admin(Condicion condicion, Person persona) {
        this.persona = persona;
        this.condicion = condicion;
    }

    public Admin() {
    }

    

    
    
}
