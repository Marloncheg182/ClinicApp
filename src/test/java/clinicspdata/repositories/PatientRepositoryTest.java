package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Patient;
import clinicspdata.entity.patients.PatientState;
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
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    @DatabaseSetup("patientData.xml")
    public void testFinByFirstName() throws Exception {
        Patient patient = patientRepository.finByFirstName("Johney");
        Assert.assertNotNull(patient);
        Assert.assertEquals("Johney", patient.getFirstName());
    }

    @Test
    @DatabaseSetup("patientData.xml")
    public void testFindByLastName() throws Exception {
        Patient patient = patientRepository.findByLastName("Depp");
        Assert.assertNotNull(patient);
        Assert.assertEquals("Depp", patient.getLastName());
    }

    @Test
    @DatabaseSetup("patientData.xml")
    public void testFindByAge() throws Exception {
        Patient patient = patientRepository.findByAge(26);
        Assert.assertNotNull(patient);
        Assert.assertEquals(52, patient.getLastName());
    }

    @Test
    @DatabaseSetup("patientData.xml")
    public void testFindByStat() throws Exception {
        Patient patient = patientRepository.findByStat(PatientState.HARD);
        Assert.assertNotNull(patient);
        Assert.assertEquals(PatientState.HARD, patient.getLastName());
    }
    @Test
    @DatabaseSetup("patientData.xml")
    @ExpectedDatabase("updatePatient.xml")
    public void updatePatient()throws Exception{
        Patient patient = new Patient();
        patient.setId(2);
        patient.setFirstName("Kobey");
        patient.setLastName("James");
        patient.setAge(28);
        patient.setState(PatientState.COMA);
        patient.setPhoneNumber("+380-...-..-..");
        patientRepository.save(patient);
    }
}