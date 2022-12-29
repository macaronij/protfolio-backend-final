package basededatos.portfolio3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String telefono;
    private String direccion;
    private String email;
    private String foto; 
    private String profesion;

    @ManyToOne
    private Person persona;

    public Contact(String telefono, String direccion, String email, String profesion, String foto, Person persona) {
        this.profesion = profesion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.foto = foto;
        this.persona = persona;
    }

    public Contact() {
    }
    
    
}
