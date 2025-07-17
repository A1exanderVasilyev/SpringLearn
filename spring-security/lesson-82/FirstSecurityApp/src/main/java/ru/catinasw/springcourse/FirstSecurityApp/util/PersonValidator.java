package ru.catinasw.springcourse.FirstSecurityApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.catinasw.springcourse.FirstSecurityApp.models.Person;
import ru.catinasw.springcourse.FirstSecurityApp.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService personService;

    @Autowired
    public PersonValidator(PeopleService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personService.loadUserByUsername(person.getUserName()).isPresent()) {
            errors.rejectValue("userName", "", "username already exist");
        }
    }
}
