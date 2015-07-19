package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Card;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.Assert.*;

/**
 * @author Oleg Romanenchuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseTestConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    @DatabaseSetup("cardData.xml")
    public void testFindById() throws Exception {
        Card card = cardRepository.findOne(1L);
        Assert.assertNotNull(card);
        Assert.assertEquals("1", card.getId());
    }

    @Test
    @DatabaseSetup("cardData.xml")
    public void testFindByName() throws Exception {
        Card card = cardRepository.findByName("Depp");
        Assert.assertNotNull(card);
        Assert.assertEquals("Depp", card.getLastName());
    }

    @Test
    @DatabaseSetup("cardData.xml")
    public void testFindByBirthDate() throws Exception {
        Card card = cardRepository.findByBirthDate("9.06.1963");
        Assert.assertNotNull(card);
        Assert.assertEquals("9.06.1963", card.getBirthDate());
    }

    @Test
    @DatabaseSetup("cardData.xml")
    @ExpectedDatabase("updateCard.xml")
    public void updateCardData() throws Exception {
        Card card = new Card();
        card.setId(1);
        card.setFirstName("Kobey");
        card.setLastName("James");
        card.setBirthDate("13.09.1987");
        card.setDiagnosis("Bullet wound");
        card.setSymptoms("penetration in area of neck");
        card.setAdditionalNotes("injured arteria, patient in coma, spinal column affected");
        cardRepository.save(card);
    }
}