package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Insurance;
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
public class InsuranceRepositoryTest {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Test
    @DatabaseSetup("insuranceData.xml")
    public void testFindById() throws Exception {
        Insurance insurance = insuranceRepository.findById(1L);
        Assert.assertNotNull(insurance);
        Assert.assertEquals(1, insurance.getBankAccount());
    }

    @Test
    @DatabaseSetup("insuranceData.xml")
    @ExpectedDatabase("updateInsurance.xml")
    public void updateInsurance()throws Exception{
        Insurance insurance = new Insurance();
        insurance.setId(1);
        insurance.setBankAccount(3425124121242423L);
    }
}