package clinicapp.Dao.Service;

import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;
import config.DBUnitConfig;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.util.List;


public class DoctorServiceImplTest extends DBUnitConfig {

    private DoctorServiceImpl doctorService = new DoctorServiceImpl();
    private EntityManager manager = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public DoctorServiceImplTest(String name) {
        super(name);
    }


    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/doctor/doctor-data.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testCreate() throws Exception {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Debra");
        doctor.setLastName("Wild");
        doctor.setAge(32);
        doctor.setPosition(DoctorPosition.SURGEON);
        doctor.setPhoneNumber("");
        doctor.setRating(Rating.SENIOR);

        doctorService.create(doctor);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/doctor/doctor-create.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "doctor", ignore);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Doctor> doctors = doctorService.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/doctor/doctor-data.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("doctor").getRowCount(), doctors.size());
    }

}