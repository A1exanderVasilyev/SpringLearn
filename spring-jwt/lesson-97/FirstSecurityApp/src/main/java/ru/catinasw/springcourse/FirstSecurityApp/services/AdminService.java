package ru.catinasw.springcourse.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.catinasw.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doAdminStuff() {
        System.out.println("admin doing he's stuff");
    }
}
