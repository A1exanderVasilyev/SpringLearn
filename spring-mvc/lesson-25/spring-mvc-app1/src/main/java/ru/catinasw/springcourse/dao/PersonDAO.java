package ru.catinasw.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.catinasw.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PERSON_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_ID, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++PERSON_ID, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++PERSON_ID, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++PERSON_ID, "Kate", 34, "katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_ID);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
