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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;


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
    @DatabaseSetup("analysisData.xml")
    public void testFindById() throws Exception {
        Analysis analysis = analysisRepository.findOne(1L);
        Assert.assertNotNull(analysis);
        Assert.assertEquals("blood pressure", analysis.getNotes());

    }

    @Test
    @DatabaseSetup("analysisData.xml")
    public void testFindByDate() throws Exception {
        Analysis analysis = analysisRepository.findByDate("12.07.2015");
        Assert.assertNotNull(analysis);
        Assert.assertEquals("12.07.2015", analysis.getDate());


    }

    @Test
    @DatabaseSetup("analysisData.xml")
    @ExpectedDatabase("updatedAnalysis.xml")
    public void testUpdateAnalysis() throws Exception {
        Analysis analysis = new Analysis();
        analysis.setId(2);
        analysis.setDate("15.07.2015");
        analysis.setNotes("Estimation of thrombocyte, erythrocyte  and leukocyte level");
        analysisRepository.save(analysis);

    }
}