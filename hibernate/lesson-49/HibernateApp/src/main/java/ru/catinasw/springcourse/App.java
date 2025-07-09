package ru.catinasw.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.catinasw.springcourse.model.Person;

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
            Person newPerson1 = new Person("Test1", 22);
            Person newPerson2 = new Person("Test2", 25);
            Person newPerson3 = new Person("Test3", 21);

            session.persist(newPerson1);
            session.persist(newPerson2);
            session.persist(newPerson3);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
