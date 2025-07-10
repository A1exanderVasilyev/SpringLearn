package ru.catinasw.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.catinasw.springcourse.model.Passport;
import ru.catinasw.springcourse.model.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Person person = new Person("test person", 28);
//            person.setPassport(new Passport(123488));
//            session.persist(person);


//            Person person = session.find(Person.class, 2);
//            System.out.println(person.getPassport());
//
//            Passport passport = session.find(Passport.class, 1);
//            System.out.println(passport.getPerson());

//            Person person = session.find(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());
//
//            person.getPassport().setPassportNumber(223344);
//            System.out.println(person.getPassport().getPassportNumber());
//            session.remove(passport);
            Person person = session.find(Person.class, 4);
            Passport passport = person.getPassport();
            session.detach(passport);
//            session.remove(passport);
            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
