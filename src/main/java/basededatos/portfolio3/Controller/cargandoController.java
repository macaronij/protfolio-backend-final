package basededatos.portfolio3.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import basededatos.portfolio3.Model.About;

import basededatos.portfolio3.Model.Education;
import basededatos.portfolio3.Model.Message;
import basededatos.portfolio3.Model.Person;
import basededatos.portfolio3.Model.Proyect;
import basededatos.portfolio3.Repository.AboutRepository;
import basededatos.portfolio3.Repository.AdminRepository;
import basededatos.portfolio3.Repository.ContactRepository;
import basededatos.portfolio3.Repository.EducationRepository;
import basededatos.portfolio3.Repository.MessageRepository;
import basededatos.portfolio3.Repository.PersonRepository;
import basededatos.portfolio3.Repository.ProyectRepository;

@Slf4j
@RestController
@RequestMapping(path = "/cargando", produces="application/json")
@CrossOrigin(origins = "*")
public class cargandoController {
    PersonRepository personRepo;
    EducationRepository educationRepo;
    AboutRepository aboutRepo;
    AdminRepository adminRepo;
    ContactRepository contactRepo;
    ProyectRepository proyectRepo;
    MessageRepository messageRepo;

    cargandoController(PersonRepository _personRepo, EducationRepository _educactionRepo, AboutRepository _aboutRepo, AdminRepository _adminRepo, ContactRepository _contactRepo, ProyectRepository _proyectRepo, MessageRepository _messageRepo) {
        personRepo = _personRepo;
        educationRepo = _educactionRepo;
        aboutRepo = _aboutRepo;
        adminRepo = _adminRepo;
        contactRepo = _contactRepo;
        proyectRepo = _proyectRepo;
        messageRepo = _messageRepo;
    }


    @PostMapping("/educacion")
    public Boolean cargaEducacion(@RequestBody Education datos) {
        log.info("Cargando EDUCACION");
        log.info("id recibido: "+datos.getTitulo());
        log.info("id recibido: "+datos.getId());
        if (personRepo.existsById(datos.getId())) {
            Person persona = personRepo.findById(datos.getId()).get();
            log.info("Cargando EDUCACION de Persona: "+persona.getNombre());
            log.info("foto: "+datos.getFoto()+" titulo: "+datos.getTitulo()+" datos: "+datos.getTexto()+" persona: "+ persona.getNombre());
            Education edu = new Education(datos.getFoto(), datos.getTitulo(),datos.getTexto(), datos.getFecha(), persona);
            log.info("objeto edu creado");
            educationRepo.save(edu);
        } else {
            log.info("ID: "+datos.getId()+" no encontrado en tabla persona");
            return false;
        }
        return true;
    }
    
    @PostMapping("/message")
    public Boolean cargaMensaje(@RequestBody Message datos) {
        log.info("Cargando MENSAJE");
        if (personRepo.existsById(datos.getId())) {
            Person persona = personRepo.findById(datos.getId()).get();
            log.info("Guardando MENSAJE para "+persona.getNombre());
            log.info(datos.getEmail());
            messageRepo.save(new Message(datos.getNombre(), datos.getEmail(), datos.getMensaje(), persona));
        } else {
            log.info("ID: "+datos.getId()+" no encontrado en tabla persona");
            return false;
        }
        return true;
    }

    @PostMapping("/about")
    public Boolean cargaAbaout(@RequestBody About datos) {
        log.info("Cargando ABOUT");
        if (personRepo.existsById(datos.getId())) {
            Person persona = personRepo.findById(datos.getId()).get();
            log.info("Cargando ABOUT de Persona: "+persona.getNombre());
            aboutRepo.save(new About(datos.getTitulo(), datos.getTexto(),persona ));
        } else {
            log.info("ID: "+datos.getId()+" no encontrado en tabla persona");
            return false;
        }
        return true;
    }


    @PostMapping("/proyect")
    public Boolean cargaPro(@RequestBody Proyect datos) {
        log.info("Cargando PROYECTO");
        if (personRepo.existsById(datos.getId())) {
            Person persona = personRepo.findById(datos.getId()).get();
            log.info("Cargando PROYECTO de Persona: "+persona.getNombre());
            proyectRepo.save(new Proyect(datos.getFoto(), datos.getTitulo(), datos.getTexto(), datos.getEnlace(),datos.getFecha(), persona));
        } else {
            log.info("ID: "+datos.getId()+" no encontrado en tabla persona");
            return false;
        }
        return true;
    }
}
