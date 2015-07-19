package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Clinic;
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
public class ClinicRepositoryTest {

    @Autowired
    private ClinicRepository clinicRepository;

    @Test
    @DatabaseSetup("clinicData.xml")
    public void testFindByName() throws Exception {
        Clinic clinic = clinicRepository.findByName("Pringston-Plaintsboro");
        Assert.assertNotNull(clinic);
        Assert.assertEquals("Pringston-Plaintsboro", clinic.getName());

    }

    @Test
    @DatabaseSetup("clinicData.xml")
    public void testFindById() throws Exception {
        Clinic clinic = clinicRepository.findOne(1L);
        Assert.assertNotNull(clinic);
        Assert.assertEquals("Pringston-Plaintsboro", clinic.getName());

    }

    @Test
    @DatabaseSetup("clinicData.xml")
    @ExpectedDatabase("updateClinic.xml")
    public void updateData()throws Exception{
        Clinic clinic = new Clinic();
        clinic.setId(2);
        clinic.setName("Kharkiv city Clinic ¹4");
        clinicRepository.save(clinic);
    }
}