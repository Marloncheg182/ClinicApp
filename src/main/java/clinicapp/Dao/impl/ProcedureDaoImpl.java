package clinicapp.Dao.impl;

import clinicapp.Dao.ProcedureDAO;
import clinicapp.entity.Procedure;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedureDaoImpl implements ProcedureDAO {

    public static final Logger LOGGER = Logger.getLogger(ProcedureDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Procedure procedure) {
        sessionFactory.getCurrentSession().save(procedure);
    }

    @Override
    public int getById() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM procedure WHERE procedure.id = id").getFirstResult();
    }

    @Override
    public String getByDate() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM procedure WHERE procedure.date = date").getQueryString();
    }

    @Override
    public List<Procedure> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM procedure").list();
    }

    @Override
    public void update(Procedure procedure) {
        sessionFactory.getCurrentSession().save(procedure);
    }

    @Override
    public void delete(Integer id) {
        Procedure procedure = (Procedure) sessionFactory.getCurrentSession().load(
                Procedure.class, id);
        if (null != procedure) {
            sessionFactory.getCurrentSession().delete(procedure);
        }
        else LOGGER.error("Nothing to delete");
    }
}
