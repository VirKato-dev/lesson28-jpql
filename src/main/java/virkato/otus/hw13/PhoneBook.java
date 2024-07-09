package virkato.otus.hw13;

import virkato.otus.hw13.config.HibernateConfig;

public class PhoneBook {
    public static void main(String[] args) {
        HibernateConfig.getSessionFactory();
    }
}
