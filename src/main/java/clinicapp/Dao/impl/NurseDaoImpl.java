package clinicapp.Dao.impl;

import clinicapp.Dao.NurseDAO;
import clinicspdata.entity.Nurse;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NurseDaoImpl implements NurseDAO {

    public static final Logger LOGGER = Logger.getLogger(NurseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Nurse nurse) {
        sessionFactory.getCurrentSession().save(nurse);
    }

    @Override
    public String getByFirstName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM nurse WHERE nurse.first_name = :first_name").getQueryString();
    }

    @Override
    public String getByLastName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM nurse WHERE nurse.last_name = :last_name").getQueryString();
    }

    @Override
    public String getByPosition() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM nurse WHERE nurse.position = :position").getQueryString();
    }

    @Override
    public List<Nurse> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM nurse").list();
    }

    @Override
    public void update(Nurse nurse) {
        sessionFactory.getCurrentSession().save(nurse);
    }

    @Override
    public void delete(Integer id) {
        Nurse nurse = (Nurse) sessionFactory.getCurrentSession().load(
                Nurse.class, id);
        if (null != nurse) {
            sessionFactory.getCurrentSession().delete(nurse);
        }

        else LOGGER.error("Nothing to delete");
    }

}
