package virkato.otus.hw13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virkato.otus.hw13.config.HibernateConfig;
import virkato.otus.hw13.entities.Address;
import virkato.otus.hw13.entities.Client;
import virkato.otus.hw13.entities.Phone;

import java.util.Set;

class PhoneBookTest {

    SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Test
    void test() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(
                    new Client("Васильев Василий Васильевич",
                            new Address("г.Нский, ул.Новая, д.1, кв.1"),
                            Set.of(new Phone("555"))
                    )
            );

            session.getTransaction().commit();

            // other entity

            session.beginTransaction();

            session.persist(
                    new Client("Петров Пётр Петрович",
                            new Address("г.Нский, ул.Новая, д.1, кв.1"),
                            Set.of(new Phone("777"))
                    )
            );

            session.getTransaction().commit();
        }
    }
}