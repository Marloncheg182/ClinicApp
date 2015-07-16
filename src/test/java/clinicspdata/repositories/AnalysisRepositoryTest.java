package clinicspdata.repositories;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.entity.Analysis;
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
public class AnalysisRepositoryTest {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Test
    @

    public void testFindById() throws Exception {
        Analysis analysis = analysisRepository.findById(1);

    }

    @Test
    @DatabaseSetup()
    public void testFindByDate() throws Exception {
        Analysis analysis = analysisRepository.findByDate("12.07.2015");
        Assert.assertNotNull(analysis);
        Assert.assertEquals("12.07.2015", analysis.getDate());

    }
}