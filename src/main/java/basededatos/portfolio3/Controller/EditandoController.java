package basededatos.portfolio3.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basededatos.portfolio3.Model.About;
import basededatos.portfolio3.Model.Education;
import basededatos.portfolio3.Model.Proyect;
import basededatos.portfolio3.Repository.AboutRepository;
import basededatos.portfolio3.Repository.EducationRepository;
import basededatos.portfolio3.Repository.ProyectRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/editando", produces="application/json")
@CrossOrigin(origins = "*")
public class EditandoController {

    EducationRepository educationRepo;
    ProyectRepository proyectRepo;
    AboutRepository aboutRepo;

    public EditandoController(EducationRepository _educactionRepo, ProyectRepository _proyectRepo, AboutRepository _aboutRepo) {
        educationRepo = _educactionRepo;
        proyectRepo = _proyectRepo;
        aboutRepo = _aboutRepo;
    }

    @PostMapping("/education/{idLinea}")
    public Boolean editarEducacion(@RequestBody Education datos, @PathVariable String idLinea){
        log.info("Editando EDUCACION");
        log.info("El ide de linea es: "+idLinea);
        Long id = Long.parseLong(idLinea);
        if (educationRepo.findById(id).isPresent()) {
            log.info("encontre el ID en educacion");
            Education edu = educationRepo.findById(id).get();
            edu.setFoto(datos.getFoto());
            edu.setTitulo(datos.getTitulo());
            edu.setTexto(datos.getTexto());
            edu.setFecha(datos.getFecha());
            educationRepo.save(edu);
            return true;
        } else {
            log.info("Error no se encontro el ID");
            return false;
        }
    }

    @PostMapping("/proyect/{idLinea}")
    public Boolean editarProyecto(@RequestBody Proyect datos, @PathVariable String idLinea){
        log.info("Editando PROYECT");
        log.info("El id de linea es: "+idLinea);
        Long id = Long.parseLong(idLinea);
        if (proyectRepo.findById(id).isPresent()) {
            log.info("encontre el ID en proyect");
            Proyect pro = proyectRepo.findById(id).get();
            pro.setFoto(datos.getFoto());
            pro.setTitulo(datos.getTitulo());
            pro.setTexto(datos.getTexto());
            pro.setEnlace(datos.getEnlace());
            pro.setFecha(datos.getFecha());
            proyectRepo.save(pro);
            return true;
        } else {
            log.info("Error no se encontro el ID");
            return false;
        }
    }

    @PostMapping("/about/{idLinea}")
    public Boolean editarAbout(@RequestBody About datos, @PathVariable String idLinea){
        log.info("Editando ABOUT");
        log.info("El id de linea es: "+idLinea);
        Long id = Long.parseLong(idLinea);
        if (aboutRepo.findById(id).isPresent()) {
            log.info("encontre el ID en about");
            About sobremi = aboutRepo.findById(id).get();
            sobremi.setTitulo(datos.getTitulo());
            sobremi.setTexto(datos.getTexto());
            aboutRepo.save(sobremi);
            return true;
        } else {
            log.info("Error no se encontro el ID");
            return false;
        }
    }
}
