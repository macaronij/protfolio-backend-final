package basededatos.portfolio3.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basededatos.portfolio3.Model.Education;
import basededatos.portfolio3.Model.Proyect;
import basededatos.portfolio3.Repository.EducationRepository;
import basededatos.portfolio3.Repository.ProyectRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/cargando", produces="application/json")
@CrossOrigin(origins = "*")
public class EditandoController {

    EducationRepository educationRepo;
    ProyectRepository proyectRepo;

    public EditandoController(EducationRepository _educactionRepo, ProyectRepository _proyectRepo) {
        educationRepo = _educactionRepo;
        proyectRepo = _proyectRepo;
    }



    @PostMapping("/editando/education/{idString}")
    public Boolean editarEducacion(@RequestBody Education datos){
        log.info("Editando EDUCACION");
        Long id = datos.getId();
        if (educationRepo.findById(id).isPresent()) {
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

    @PostMapping("/editando/proyect/{idString}")
    public Boolean editarProyecto(@RequestBody Proyect datos){
        log.info("Editando EDUCACION");
        Long id = datos.getId();
        if (educationRepo.findById(id).isPresent()) {
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
}
