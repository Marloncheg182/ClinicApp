package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Nurse;
import clinicspdata.entity.nurses.NursePosition;
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
public class NurseRepositoryTest {

    @Autowired
    private NurseRepository nurseRepository;

    @Test
    @DatabaseSetup("nurseData.xml")
    public void testFindByFirstName() throws Exception {
        Nurse nurse = nurseRepository.findByFirstName("Alice");
        Assert.assertNotNull(nurse);
        Assert.assertEquals("Alice", nurse.getFirstName());
    }

    @Test
    @DatabaseSetup("nurseData.xml")
    public void testFindByLastName() throws Exception {
        Nurse nurse = nurseRepository.findByLastName("Wonder");
        Assert.assertNotNull(nurse);
        Assert.assertEquals("Wonder", nurse.getLastName());
    }

    @Test
    @DatabaseSetup("nurseData.xml")
    public void testFindByAge() throws Exception {
        Nurse nurse = nurseRepository.findByAge(25);
        Assert.assertNotNull(nurse);
        Assert.assertEquals(25, nurse.getAge());
    }

    @Test
    @DatabaseSetup("nurseData.xml")
    public void testFindByPosition() throws Exception {
        Nurse nurse = nurseRepository.findByPosition(NursePosition.CRNA);
        Assert.assertNotNull(nurse);
        Assert.assertEquals(NursePosition.CRNA, nurse.getPosition());
    }
    @Test
    @DatabaseSetup("nurseData.xml")
    @ExpectedDatabase("updateNurse.xml")
    public void updateNurse() throws Exception{
        Nurse nurse = new Nurse();
        nurse.setId(2);
        nurse.setFirstName("Merry");
        nurse.setLastName("Jane");
        nurse.setAge(32);
        nurse.setPosition(NursePosition.CNS);
        nurse.setPhoneNumber("+380-...-..-..");
        nurseRepository.save(nurse);
    }
}