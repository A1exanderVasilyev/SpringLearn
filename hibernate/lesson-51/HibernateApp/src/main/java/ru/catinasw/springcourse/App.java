package ru.catinasw.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.catinasw.springcourse.model.Person;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            session.createMutationQuery("update Person set name = 'TESt' where age < 30").executeUpdate();
            session.createMutationQuery("delete From Person where age < 30").executeUpdate();
            List<Person> people = session.createQuery("FROM Person", Person.class).getResultList();

            for (Person person: people) {
                System.out.println(person);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
