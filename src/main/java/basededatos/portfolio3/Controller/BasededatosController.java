package basededatos.portfolio3.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basededatos.portfolio3.Model.About;
import basededatos.portfolio3.Model.Admin;
import basededatos.portfolio3.Model.Contact;
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

@RestController
@RequestMapping("/basededatos")
@CrossOrigin(origins = "*")
public class BasededatosController {
    private PersonRepository personRepo;
    private EducationRepository eduRepo;
    private AboutRepository aboutRepo;
    private AdminRepository adminRepo;
    private ContactRepository contactRepo;
    private ProyectRepository proyectRepo;
    private MessageRepository messageRepo;

    public BasededatosController(PersonRepository _personRepo, EducationRepository _eduRepo, AboutRepository _aboutRepo, AdminRepository _adminRepo, ContactRepository _contactRepo, ProyectRepository _proyectRepo, MessageRepository _messageRepo) {
        personRepo = _personRepo;
        eduRepo = _eduRepo;
        aboutRepo = _aboutRepo;
        adminRepo = _adminRepo;
        contactRepo = _contactRepo;
        proyectRepo = _proyectRepo;
        messageRepo = _messageRepo;
    }

    @GetMapping("persons")
    public Iterable<Person> mostrarPerson() {
        return personRepo.findAll();
    }
    @GetMapping("persons/{idString}")
    public Person mostrarPersonsId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        if (personRepo.findById(id).isPresent()) {
            return personRepo.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping("educations")
    public Iterable<Education> mostrarEdu() {
        return eduRepo.findAll();
    }
    @GetMapping("educations/{idString}")
    public Iterable<Education> mostrarEduId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return eduRepo.findByPersonaId(id);
    }

    @GetMapping("messages")
    public Iterable<Message> mostrarMes() {
        return messageRepo.findAll();
    }
    @GetMapping("messages/{idString}")
    public Iterable<Message> mostrarMesId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return messageRepo.findByPersonaId(id);
    }
    
    @GetMapping("abouts")
    public Iterable<About> mostrarAbout() {
        return aboutRepo.findAll();
    }
    @GetMapping("abouts/{idString}")
    public Iterable<About> mostrarAboutId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return aboutRepo.findByPersonaId(id);
    }

    @GetMapping("admins")
    public Iterable<Admin> mostrarAdmin() {
        return adminRepo.findAll();
    }
    @GetMapping("admins/{idString}")
    public Iterable<Admin> mostrarAdminId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return adminRepo.findByPersonaId(id);
    }

    @GetMapping("contacts")
    public Iterable<Contact> mostrarContact() {
        return contactRepo.findAll();
    }
    @GetMapping("contacts/{idString}")
    public Iterable<Contact> mostrarContactId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return contactRepo.findByPersonaId(id);
    }

    @GetMapping("proyects")
    public Iterable<Proyect> mostrarPro() {
        return proyectRepo.findAll();
    }
    @GetMapping("proyects/{idString}")
    public Iterable<Proyect> mostrarProId(@PathVariable String idString) {
        Long id = Long.parseLong(idString);
        return proyectRepo.findByPersonaId(id);
    }
}
