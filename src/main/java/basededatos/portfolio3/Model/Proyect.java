package basededatos.portfolio3.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Proyect {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String foto;
    private String titulo;
    private String texto;
    private String enlace;
    private String fecha;

    @ManyToOne
    private Person persona;

    public Proyect(String foto, String titulo, String texto, String enlace,  String fecha, Person persona) {
        this.foto = foto;
        this.titulo = titulo;
        this.texto = texto;
        this.persona = persona;
        this.enlace = enlace;
        this.fecha = fecha;
    }

    public Proyect() {
    }

    
    
}
