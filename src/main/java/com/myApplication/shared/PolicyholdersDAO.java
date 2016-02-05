package com.myApplication.shared;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by DaH4uk on 06.02.2016.
 */
public class PolicyholdersDAO {
    private Session session;

    public PolicyholdersDAO(Session session) {
        this.session = session;
    }

    public void save(Policyholders dataSet) {
        session.save(dataSet);
        session.close();
    }

    public Policyholders read(long id) {
        return (Policyholders) session.load(Policyholders.class, id);
    }

    public Policyholders readByName(String name) {
        Criteria criteria = session.createCriteria(Policyholders.class);
        return (Policyholders) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Policyholders> readAll() {
        Criteria criteria = session.createCriteria(Policyholders.class);
        return criteria.list();
    }
}
