package ru.netology.secure_methods.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.secure_methods.service.MethodSecurityService;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class MethodSecurityController {
    private final MethodSecurityService methodSecurityService;

    public MethodSecurityController(MethodSecurityService methodSecurityService) {
        this.methodSecurityService = methodSecurityService;
    }

    @GetMapping("/")
    public String hi() {
        return methodSecurityService.homePage();
    }



    @GetMapping("/welcome")
    @PreAuthorize("#username == authentication.principal.username")
    public String welcome(String username) {
        return methodSecurityService.welcome() + username + " вы находитесь на домашней странице нашего сайта, вы можете продолжить работу в соответствии с Вашим статусом";
    }


    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read(Principal principal) {
        return methodSecurityService.read(principal);
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String write(Principal principal) {
        return methodSecurityService.write(principal);
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String delete(Principal principal) {
        return methodSecurityService.delete(principal);
    }



}
