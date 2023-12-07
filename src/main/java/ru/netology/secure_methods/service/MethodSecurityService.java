package ru.netology.secure_methods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.secure_methods.repository.MethodSecurityRepository;

import java.security.Principal;

@Service
public class MethodSecurityService {
    private final MethodSecurityRepository methodSecurityRepository;


    public MethodSecurityService(MethodSecurityRepository methodSecurityRepository) {
        this.methodSecurityRepository = methodSecurityRepository;
    }

    public String homePage() {
        return methodSecurityRepository.getHomePage();
    }

    public String welcome() {
        return methodSecurityRepository.getWelcome();
    }

    public String read(Principal principal) {
        return methodSecurityRepository.getRead(principal);
    }

    public String write(Principal principal) {
        return methodSecurityRepository.getWrite(principal);
    }

    public String delete(Principal principal) {
        return methodSecurityRepository.getDelete(principal);
    }







}
