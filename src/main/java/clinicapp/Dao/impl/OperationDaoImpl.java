package clinicapp.Dao.impl;

import clinicapp.Dao.OperationDAO;
import clinicapp.entity.Operation;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDaoImpl implements OperationDAO {

    public static final Logger LOGGER = Logger.getLogger(OperationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(Operation operation) {
        sessionFactory.getCurrentSession().save(operation);
    }

    @Override
    public int getById() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM operation WHERE operation.id = id").getFirstResult();
    }

    @Override
    public String getByDate() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM operation WHERE operation.date = date").getQueryString();
    }

    @Override
    public List<Operation> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM operation").list();
    }

    @Override
    public void update(Operation operation) {
        sessionFactory.getCurrentSession().save(operation);
    }

    @Override
    public void delete(long id) {
        Operation operation = (Operation) sessionFactory.getCurrentSession().load(
                Operation.class, id);
        if (null != operation) {
            sessionFactory.getCurrentSession().delete(operation);
        }
        else LOGGER.error("Nothing to delete");
    }
}
