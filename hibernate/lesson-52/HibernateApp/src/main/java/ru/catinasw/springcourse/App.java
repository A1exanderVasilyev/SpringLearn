package ru.catinasw.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.catinasw.springcourse.model.Item;
import ru.catinasw.springcourse.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = session.find(Person.class, 3);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            Item item = session.find(Item.class, 5);
//            System.out.println(item);
//            Person person = item.getOwner();
//            System.out.println(person);

//            Person person = session.find(Person.class, 2);
//            Item newItem = new Item("item from hibernate2", person);
//            person.getItems().add(newItem);
//            session.persist(newItem);
//            System.out.println(person.getItems());

//            Person person = new Person("test person", 21);
//            Item item = new Item("test item", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//
//            session.persist(person);
//            session.persist(item);


//            Person person = session.find(Person.class, 3);
//            List<Item> items = person.getItems();
//            for (Item item: items) {
//                session.remove(item);
//            }
//            person.getItems().clear();

//            Person person = session.find(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(
//                    item -> item.setOwner(null)
//            );


            Person person = session.find(Person.class, 4);
            Item item = session.find(Item.class, 1);
            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
