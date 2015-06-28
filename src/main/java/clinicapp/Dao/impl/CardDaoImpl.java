package clinicapp.Dao.impl;


import clinicapp.Dao.CardDAO;
import clinicapp.entity.Card;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoImpl implements CardDAO {

    public static final Logger LOGGER = Logger.getLogger(CardDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Card card) {
        sessionFactory.getCurrentSession().save(card);
    }

    @Override
    public String getByFirstName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM card WHERE card.first_name = :first_name").getQueryString();
    }

    @Override
    public String getByLastName() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM card WHERE card.last_name = :last_name").getQueryString();
    }

    @Override
    public int getById() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM card WHERE card.id =:id").getFirstResult();
    }

    @Override
    public List<Card> getAll() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM card").list();
    }

    @Override
    public void update(Card card) {
        sessionFactory.getCurrentSession().save(card);
    }

    @Override
    public void delete(Integer id) {
        Card card = (Card) sessionFactory.getCurrentSession().load(
                Card.class, id);
        if (null != card) {
            sessionFactory.getCurrentSession().delete(card);
        }
        else LOGGER.error("Error while deleting");
    }
}
