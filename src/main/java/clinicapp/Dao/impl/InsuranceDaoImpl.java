package clinicapp.Dao.impl;


import clinicapp.Dao.InsuranceDAO;
import clinicapp.entity.Insurance;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InsuranceDaoImpl implements InsuranceDAO {

    public static final Logger LOGGER = Logger.getLogger(InsuranceDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Insurance insurance) {
        sessionFactory.getCurrentSession().save(insurance);
    }

    @Override
    public String getByBankAccount() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM insurance WHERE insurance.bank_account = :bank_account").getQueryString();
    }

    @Override
    public List<Insurance> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM insurance").list();
    }

    @Override
    public void update(Insurance insurance) {
        sessionFactory.getCurrentSession().save(insurance);
    }

    @Override
    public void delete(Integer id) {
        Insurance insurance = (Insurance) sessionFactory.getCurrentSession().load(
                Insurance.class, id);
        if (null != insurance) {
            sessionFactory.getCurrentSession().delete(insurance);
        }

        else LOGGER.error("Nothing to delete");
    }

}
