package basededatos.portfolio3.Controller;

import basededatos.portfolio3.Model.Admin;
import basededatos.portfolio3.Model.LoginData;
import basededatos.portfolio3.Repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(path = "basededatos/login")
@CrossOrigin(origins = "*")
public class LoginController {
    private AdminRepository adminrepo;

    public LoginController(AdminRepository _adminRepo) {
        adminrepo = _adminRepo;
    }

    @GetMapping
    public boolean rechazarGet() {
        log.info("NO USAR GET");
        return false;
    }
    
    @PostMapping
    public boolean comprobarPassword(@RequestBody LoginData loginData) {
        log.info("recibido pedido psot de LOGIN");
        log.info("El id de login es "+loginData.getId());
        Long idLong = Long.parseLong(loginData.getId());
        Admin datosAdmin = adminrepo.findFirstByPersonaId(idLong);
        if (datosAdmin.getPassword().equals(loginData.getPassword())) {
            log.info("login ACEPTADO");
            return true;
        } else {
            log.info("login RECHAZADO");
            return false;
        }
    }
}
