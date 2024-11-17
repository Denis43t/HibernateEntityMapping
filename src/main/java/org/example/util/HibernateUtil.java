package org.example.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import org.example.model.Client;
import org.example.model.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import java.util.Properties;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private static Configuration hibernateConfig = new Configuration().configure("hibernate.cfg.xml");

    private static Properties hibernateProperties = hibernateConfig.getProperties();

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    @Getter
    private SessionFactory sessionFactory;

    static {
        config.setJdbcUrl(hibernateProperties.getProperty("hibernate.connection.url"));
        config.setUsername(hibernateProperties.getProperty("hibernate.connection.username"));
        config.setPassword(hibernateProperties.getProperty("hibernate.connection.password"));
        config.setDriverClassName(hibernateProperties.getProperty("hibernate.connection.driver_class"));
        INSTANCE = new HibernateUtil();
        ds=new HikariDataSource(config);
        Flyway flyway = Flyway.configure()
                .dataSource(ds)
                .locations("db/migrations")
                .load();
        flyway.migrate();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();

    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}


