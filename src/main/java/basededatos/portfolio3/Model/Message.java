package basededatos.portfolio3.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String nombre;
    private String email;
    private String mensaje;
    private Date fecha;

    private Boolean leido;
    
    @ManyToOne
    private Person persona;
    
    @PrePersist
    void fechar() {
        this.fecha = new Date();
        this.leido = false;
    }

    public Message() {
    }

    public Message(String nombre, String email, String mensaje, Person persona) {
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
        this.persona = persona;
    }

    
}
