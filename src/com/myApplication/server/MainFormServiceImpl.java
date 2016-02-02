package com.myApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myApplication.client.MainFormService;
import com.myApplication.shared.ContractsDataSet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class MainFormServiceImpl extends RemoteServiceServlet implements MainFormService {
    private SessionFactory sessionFactory;
    private Session session;
    private List ContractsList = new ArrayList<>();


//    public MainFormServiceImpl() {
//        sessionFactory = HibernateUtil.getSessionFactory();
//        session = sessionFactory.openSession();
//    }
//
//    public List<ContractsDataSet> getAllContracts() {
//        Query query =  session.createQuery("from ContractsDataSet");
//        ContractsList = query.list();
//        return ContractsList;
//    }
//
//    public ContractsDataSet saveContract(ContractsDataSet contractsDataSet){
//        session.save(contractsDataSet);
//        return null;
//    }

    // Implementation of sample interface method
    public String getMessage(String msg) {

        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }





}