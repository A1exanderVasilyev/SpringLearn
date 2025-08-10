package ru.catinasw.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.catinasw.springcourse.FirstSecurityApp.models.Person;
import ru.catinasw.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.catinasw.springcourse.FirstSecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<Person> person = peopleRepository.findByUserName(username);
         if (person.isEmpty()) {
             throw new UsernameNotFoundException("User not found");
         }
         return new PersonDetails(person.get());
    }
}
