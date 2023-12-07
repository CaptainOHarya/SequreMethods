package ru.netology.secure_methods.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.Principal;

@Repository
public class MethodSecurityRepository {

 /*   @Autowired
    public MethodSecurityRepository() {

    }*/

    public String getHomePage() {
        return "Здравствуйте, вы находитесь на домашней странице нашего сайта.";
    }

    public String getWelcome() {
        return "Здравствуйте,  " ;
    }


    public String getRead(Principal principal) {
        return "С продолжением работы Вас " + principal.getName() + ". Это страница где можно прочитать много важной информации о наших услугах.";
    }

    public String getWrite(Principal principal) {
        return "С продолжением работы Вас " + principal.getName() + ". Это страница для добавления данных, здесь вы можете добавить свою услугу.";
    }

    public String getDelete(Principal principal) {
        return "С продолжением работы Вас " + principal.getName() + ". Вы являетесь администратором данного сайта и вы имеете право удалить устаревшие данные.";
    }

}
