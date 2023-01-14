package basededatos.portfolio3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String foto;
    private String titulo;
    private String texto;
    private String fecha;

    @ManyToOne
    private Person persona;

    public Education(String foto, String titulo, String texto, String fecha, Person persona) {
        this.foto = foto;
        this.titulo = titulo;
        this.texto = texto;
        this.persona = persona;
        this.fecha = fecha;
    }

    public Education() {
    }   
}