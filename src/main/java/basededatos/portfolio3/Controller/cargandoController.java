package basededatos.portfolio3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import basededatos.portfolio3.Model.About;
import basededatos.portfolio3.Model.Admin;
import basededatos.portfolio3.Model.Contact;
import basededatos.portfolio3.Model.Education;
import basededatos.portfolio3.Model.Person;
import basededatos.portfolio3.Model.Proyect;
import basededatos.portfolio3.Repository.AboutRepository;
import basededatos.portfolio3.Repository.AdminRepository;
import basededatos.portfolio3.Repository.ContactRepository;
import basededatos.portfolio3.Repository.EducationRepository;
import basededatos.portfolio3.Repository.PersonRepository;
import basededatos.portfolio3.Repository.ProyectRepository;

@Slf4j
@Controller
@RequestMapping(path = "/cargando")
public class cargandoController {
    PersonRepository personRepo;
    EducationRepository educationRepo;
    AboutRepository aboutRepo;
    AdminRepository adminRepo;
    ContactRepository contactRepo;
    ProyectRepository proyectRepo;

    cargandoController(PersonRepository _personRepo, EducationRepository _educactionRepo, AboutRepository _aboutRepo, AdminRepository _adminRepo, ContactRepository _contactRepo, ProyectRepository _proyectRepo) {
        personRepo = _personRepo;
        educationRepo = _educactionRepo;
        aboutRepo = _aboutRepo;
        adminRepo = _adminRepo;
        contactRepo = _contactRepo;
        proyectRepo = _proyectRepo;
    }

    @GetMapping(value="/persona")
    public String cargaPersona(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            log.info("no se encontro un nombre para cargar, volviendo a mostrar.html");
            return "redirect:/admin/mostrar.html";
        }
        log.info("Guardando Persona "+nombre+" en la base de datos PERSON");
        personRepo.save(new Person(nombre));
        return "redirect:/admin/mostrar.html";
    }

    @GetMapping("/educacion")
    public String cargaEducacion(String foto, String titulo, String texto, String idPersona) {
        log.info("Cargando EDUCACION de ID: "+idPersona);
        Long id = Long.parseLong(idPersona);
        if (personRepo.existsById(id)) {
            Person persona = personRepo.findById(id).get();
            log.info("Cargando EDUCACION de Persona: "+persona.getNombre());
            educationRepo.save(new Education(foto, titulo, texto, persona));
        } else {
            log.info("ID: "+idPersona+" no encontrado en tabla persona");
            return "redirect:/admin/errorpersona.html";
        }
        return "redirect:/admin/mostrar.html";
    }

    @GetMapping("/about")
    public String cargaAbout(String titulo, String texto, String idPersona) {
        log.info("Cargando ABOUT de ID: "+idPersona);
        Long id = Long.parseLong(idPersona);
        if (personRepo.existsById(id)) {
            Person persona = personRepo.findById(id).get();
            log.info("Cargando ABOUT de Persona: "+persona.getNombre());
            aboutRepo.save(new About(titulo, texto, persona));
        } else {
            log.info("ID: "+idPersona+" no encontrado en tabla persona");
            return "redirect:/admin/errorpersona.html";
        }
        return "redirect:/admin/mostrar.html";
    }

    @GetMapping("/admin")
    public String cargaAdmin(Admin.Condicion condicion, String idPersona) {
        log.info("Cargando ADMIN de ID: "+idPersona);
        Long id = Long.parseLong(idPersona);
        if (personRepo.existsById(id)) {
            Person persona = personRepo.findById(id).get();
            log.info("Cargando ADMIN de Persona: "+persona.getNombre());
            adminRepo.save(new Admin(condicion, persona));
        } else {
            log.info("ID: "+idPersona+" no encontrado en tabla persona");
            return "redirect:/admin/errorpersona.html";
        }
        return "redirect:/admin/mostrar.html";
    }

    @GetMapping("/contact")
    public String cargaContact(String telefono, String direccion, String email, String profesion, String foto, String idPersona) {
        log.info("Cargando CONTACT de ID: "+idPersona);
        Long id = Long.parseLong(idPersona);
        if (personRepo.existsById(id)) {
            Person persona = personRepo.findById(id).get();
            log.info("Cargando COPNTACT de Persona: "+persona.getNombre());
            contactRepo.save(new Contact(telefono, direccion, email, profesion, foto, persona));
        } else {
            log.info("ID: "+idPersona+" no encontrado en tabla persona");
            return "redirect:/admin/errorpersona.html";
        }
        return "redirect:/admin/mostrar.html";
    }

    @GetMapping("/proyect")
    public String cargaProyect(String foto, String titulo, String texto, String enlace, String idPersona) {
        log.info("Cargando PROYECT de ID: "+idPersona);
        Long id = Long.parseLong(idPersona);
        if (personRepo.existsById(id)) {
            Person persona = personRepo.findById(id).get();
            log.info("Cargando PROYECT de Persona: "+persona.getNombre());
            proyectRepo.save(new Proyect(foto, titulo, texto, enlace, persona));
        } else {
            log.info("ID: "+idPersona+" no encontrado en tabla persona");
            return "redirect:/admin/errorpersona.html";
        }
        return "redirect:/admin/mostrar.html";
    }
}
