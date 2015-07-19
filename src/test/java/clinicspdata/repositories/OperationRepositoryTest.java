package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Operation;
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
public class OperationRepositoryTest {

    @Autowired
    private OperationRepository operationRepository;

    @Test
    @DatabaseSetup("operationData.xml")
    public void testFindById() throws Exception {
        Operation operation = operationRepository.findById(1L);
        Assert.assertNotNull(operation);
        Assert.assertEquals(1, operation.getType());
    }

    @Test
    @DatabaseSetup("operationData.xml")
    public void testFindByDate() throws Exception {
        Operation operation = operationRepository.findByDate("16.07.2015");
        Assert.assertNotNull(operation);
        Assert.assertEquals(1, operation.getType());
    }

    @Test
    @DatabaseSetup("operationData.xml")
    public void testFindByType() throws Exception {
        Operation operation = operationRepository.findByType("removing the bullet from bullet hole");
        Assert.assertNotNull(operation);
        Assert.assertEquals(1, operation.getType());
    }
    @Test
    @DatabaseSetup("operationData.xml")
    @ExpectedDatabase("updateOperation.xml")
    public void updateOperation() throws Exception {
        Operation operation = new Operation();
        operation.setId(2);
        operation.setDate("17.07.2015");
        operation.setType("recovery of some health functions");
        operation.setResult("The operation was effective");
    }
}