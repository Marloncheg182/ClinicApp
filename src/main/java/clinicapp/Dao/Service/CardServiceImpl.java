package clinicapp.Dao.Service;

import clinicapp.Dao.CardDAO;
import clinicapp.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Transactional
    public void create(Card card) {
        cardDAO.create(card);
    }

    @Transactional
    public String getByFirstName() {
        return cardDAO.getByFirstName();
    }

    @Transactional
    public String getByLastName() {
        return cardDAO.getByLastName();
    }

    @Transactional
    public int getById() {
        return cardDAO.getById();
    }

    @Transactional
    public List<Card> getAll() {
        return cardDAO.getAll();
    }

    @Transactional
    public void update(Card card) {
        cardDAO.update(card);
    }

    @Transactional
    public void delete(Integer id) {
        cardDAO.delete(id);
    }
}
