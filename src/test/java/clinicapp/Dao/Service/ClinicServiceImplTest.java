package clinicapp.Dao.Service;

import clinicspdata.entity.Clinic;
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

public class ClinicServiceImplTest extends DBUnitConfig {

    private ClinicServiceImpl clinicService = new ClinicServiceImpl();
    private EntityManager manager = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public ClinicServiceImplTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/clinic/clinic-data.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();

    }


    @Test
    public void testGetAll() throws Exception {
        List<Clinic> clinics = clinicService.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/clinic/clinic-data.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("clinic").getRowCount(), clinics.size());
    }

    @Test
    public void testCreate() throws Exception {
        Clinic clinic = new Clinic();
        clinic.setName("Pringston-Plaintsboro");

        clinicService.update(clinic);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/clinic/clinic-create.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "clinic", ignore);

    }


}