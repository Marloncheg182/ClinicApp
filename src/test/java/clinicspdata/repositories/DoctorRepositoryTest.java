package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;
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
public class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    @DatabaseSetup("doctorData.xml")
    public void testFindByFirstName() throws Exception {
        Doctor doctor = doctorRepository.findByFirstName("Gregory");
        Assert.assertNotNull(doctor);
        Assert.assertEquals("Gregory", doctor.getFirstName());
    }

    @Test
    @DatabaseSetup("doctorData.xml")
    public void testFindByLastName() throws Exception {
        Doctor doctor = doctorRepository.findByLastName("House");
        Assert.assertNotNull(doctor);
        Assert.assertEquals("House", doctor.getLastName());
    }

    @Test
    @DatabaseSetup("doctorData.xml")
    public void testFindByAge() throws Exception {
        Doctor doctor = doctorRepository.findByAge(52);
        Assert.assertNotNull(doctor);
        Assert.assertEquals(52, doctor.getLastName());
    }

    @Test
    @DatabaseSetup("doctorData.xml")
    public void testFindByPosition() throws Exception {
        Doctor doctor = doctorRepository.findByPosition(DoctorPosition.HEAD);
        Assert.assertNotNull(doctor);
        Assert.assertEquals(DoctorPosition.HEAD, doctor.getLastName());
    }

    @Test
    @DatabaseSetup("doctorData.xml")
    public void testFindByRating() throws Exception {
        Doctor doctor = doctorRepository.findByRating(Rating.HEAD);
        Assert.assertNotNull(doctor);
        Assert.assertEquals(Rating.HEAD, doctor.getLastName());
    }
    @Test
    @DatabaseSetup("doctorData.xml")
    @ExpectedDatabase("updatedDoctor.xml")
    public void updateDoctor() throws Exception {
        Doctor doctor = new Doctor();
        doctor.setId(2);
        doctor.setFirstName("Patrick");
        doctor.setLastName("Walsh");
        doctor.setAge(28);
        doctor.setPosition(DoctorPosition.SURGEON);
        doctor.setRating(Rating.MIDDLE);
        doctor.setPhoneNumber("38050-...-..-..");
        doctorRepository.save(doctor);
    }
}