package com.myApplication.server;

import com.myApplication.shared.ContractsDAO;
import com.myApplication.shared.ContractsDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by DaH4uk on 02.02.2016.
 */
public class DBService {
    private SessionFactory sessionFactory;

    public ContractsDataSet read(long id){
        Session session = sessionFactory.openSession();
        ContractsDAO dao = new ContractsDAO(session);
        ContractsDataSet contractsDataSet = dao.read(id);
        session.close();
        return contractsDataSet;
    }
}
