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

    private String password;

    public Admin(String password, Person persona) {
        this.persona = persona;
        this.password = password;
    }

    public Admin() {
    }

    

    
    
}
