package clinicapp.Dao.impl;


import clinicapp.Dao.AnalysisDAO;
import clinicspdata.entity.Analysis;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import java.util.List;

@Repository
public class AnalysisDaoImpl implements AnalysisDAO {

    public static final Logger LOGGER = Logger.getLogger(AnalysisDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Analysis analysis) {
        sessionFactory.getCurrentSession().save(analysis);
    }

    @Override
    public int getById() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM analysis WHERE analysis.id = id").getFirstResult();
    }

    @Override
    public String getByDate() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM analysis WHERE analysis.date = date").getQueryString();
    }

    @Override
    public List<Analysis> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM analysis").list();
    }

    @Override
    public void update(Analysis analysis) {
        sessionFactory.getCurrentSession().save(analysis);
    }

    @Override
    public void delete(Integer id) {
        Analysis analysis = (Analysis) sessionFactory.getCurrentSession().load(
                Analysis.class, id);
        if (null != analysis) {
            sessionFactory.getCurrentSession().delete(analysis);

        }
        else LOGGER.error("Empty data by id");
    }
}
