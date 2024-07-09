package virkato.otus.hw13.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import virkato.otus.hw13.entities.Address;
import virkato.otus.hw13.entities.Client;
import virkato.otus.hw13.entities.Phone;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            return sessionFactory;
        }

        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Phone.class)
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/virkato")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .setProperty("hibernate.connection.autocommit", "false")
                .setProperty("hibernate.default_schema", "lesson28")
                .setProperty("hibernate.hbm2ddl.auto", "create")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "false")
                .setProperty("hibernate.use_sql_comments", "false")
                .buildSessionFactory();

        return sessionFactory;
    }
}
