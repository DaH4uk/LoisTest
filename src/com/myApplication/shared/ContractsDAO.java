package com.myApplication.shared;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by DaH4uk on 02.02.2016.
 */
public class ContractsDAO {
    private Session session;

    public ContractsDAO(Session session) {
        this.session = session;
    }

    public void save(ContractsDataSet dataSet) {
        session.save(dataSet);
        session.close();
    }

    public ContractsDataSet read(long id) {
        return (ContractsDataSet) session.load(ContractsDataSet.class, id);
    }

    public ContractsDataSet readByName(String name) {
        Criteria criteria = session.createCriteria(ContractsDataSet.class);
        return (ContractsDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<ContractsDataSet> readAll() {
        Criteria criteria = session.createCriteria(ContractsDataSet.class);
        return (List<ContractsDataSet>) criteria.list();
    }
}
