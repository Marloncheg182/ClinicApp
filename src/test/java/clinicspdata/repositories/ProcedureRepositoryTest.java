package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Procedure;
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
public class ProcedureRepositoryTest {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Test
    @DatabaseSetup("procedureData.xml")
    public void testFindById() throws Exception {
        Procedure procedure = procedureRepository.findById(1L);
        Assert.assertNotNull(procedure);
        Assert.assertEquals(1, procedure.getNotes());
    }

    @Test
    @DatabaseSetup("procedureData.xml")
    public void testFindByDate() throws Exception {
        Procedure procedure = procedureRepository.findByDate("16.07.2015");
        Assert.assertNotNull(procedure);
        Assert.assertEquals("16.07.2015", procedure.getNotes());
    }

    @Test
    @DatabaseSetup("procedureData.xml")
    @ExpectedDatabase("updateProcedure.xml")
    public void updateProcedure() throws Exception {
        Procedure procedure = new Procedure();
        procedure.setId(2);
        procedure.setDate("17.07.2015");
        procedure.setNotes("replacement of bandage");
        procedureRepository.save(procedure);
    }
}