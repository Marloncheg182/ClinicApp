package clinicapp.service.impl;


import clinicapp.dbrepository.CardRepository;
import clinicapp.entity.Card;
import clinicapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public Card addCard(Card card) {
        Card saveCard = cardRepository.saveAndFlush(card);
        return saveCard;
    }

    @Override
    public Card getByFirstName(String firstName) {
        return cardRepository.findByFirstName(firstName);
    }

    @Override
    public Card getByLastName(String lastName) {
        return cardRepository.findByLastName(lastName);
    }

    @Override
    public Card getById(long id) {
        return cardRepository.findById(id);
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card editCard(Card card) {
        return cardRepository.saveAndFlush(card);
    }

    @Override
    public void delete(long id) {
        cardRepository.delete(id);
    }
}
