package com.myApplication.server.dbService;

import com.myApplication.shared.ContractsDAO;
import com.myApplication.shared.ContractsDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by DaH4uk on 02.02.2016.
 */
public class DBService {
    private SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(ContractsDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username", "tully");
        configuration.setProperty("hibernate.connection.password", "tully");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory = createSessionFactory(configuration);
    }



    public void save(ContractsDataSet dataSet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ContractsDAO dao = new ContractsDAO(session);
        dao.save(dataSet);
        transaction.commit();
    }

    public ContractsDataSet read(long id) {
        Session session = sessionFactory.openSession();
        ContractsDAO dao = new ContractsDAO(session);
        return dao.read(id);
    }

    public ContractsDataSet readByName(String name) {
        Session session = sessionFactory.openSession();
        ContractsDAO dao = new ContractsDAO(session);
        return dao.readByName(name);
    }

    public List<ContractsDataSet> readAll() {
        Session session = sessionFactory.openSession();
        ContractsDAO dao = new ContractsDAO(session);
        return dao.readAll();
    }

    public void shutdown(){
        sessionFactory.close();
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
