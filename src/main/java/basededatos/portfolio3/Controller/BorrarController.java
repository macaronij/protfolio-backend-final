package basededatos.portfolio3.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import basededatos.portfolio3.Repository.AboutRepository;
import basededatos.portfolio3.Repository.AdminRepository;
import basededatos.portfolio3.Repository.ContactRepository;
import basededatos.portfolio3.Repository.EducationRepository;
import basededatos.portfolio3.Repository.MessageRepository;
import basededatos.portfolio3.Repository.PersonRepository;
import basededatos.portfolio3.Repository.ProyectRepository;

@Slf4j
@RestController
@RequestMapping(path = "basededatos/borrar", produces="application/json")
@CrossOrigin(origins = "*")
public class BorrarController {
    PersonRepository personRepo;
    EducationRepository educationRepo;
    AboutRepository aboutRepo;
    AdminRepository adminRepo;
    ContactRepository contactRepo;
    ProyectRepository proyectRepo;
    MessageRepository messageRepo;

    public BorrarController(PersonRepository _personRepo, EducationRepository _educactionRepo, AboutRepository _aboutRepo, AdminRepository _adminRepo, ContactRepository _contactRepo, ProyectRepository _proyectRepo, MessageRepository _messageRepo) {
        personRepo = _personRepo;
        educationRepo = _educactionRepo;
        aboutRepo = _aboutRepo;
        adminRepo = _adminRepo;
        contactRepo = _contactRepo;
        proyectRepo = _proyectRepo;
        messageRepo = _messageRepo;
    }
    


    @GetMapping("/person/{idString}")
    public String borrarPersona(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            personRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/education/{idString}")
    public String borrarEducacion(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            educationRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/about/{idString}")
    public String borrarAbout(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            aboutRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/admin/{idString}")
    public String borrarAdmin(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            adminRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/contact/{idString}")
    public String borrarContact(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            contactRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/proyect/{idString}")
    public String borrarProyect(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            proyectRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

    @GetMapping("/message/{idString}")
    public String borrarMessage(@PathVariable String idString){
        Long id = Long.parseLong(idString);
        try {
            messageRepo.deleteById(id);
            log.info("Borrado");
            return "redirect:/admin/mostrar.html";
        } catch(Exception e) {
            log.error("ERROR BORRANDO", e);
            return "redirect:/admin/mostrar.html";
        }
    }

}
