package clinicspdata.services;

import clinicspdata.config.DatabaseTestConfig;
import clinicspdata.util.AnalysisUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Oleg Romanenchuk
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseTestConfig.class)
@WebAppConfiguration
public class AnalysisServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private AnalysisService analysisService;


    @Before
    public void setUp() throws Exception {
       em = emf.createEntityManager();
    }

    @Test
    public void testCreate() throws Exception {
        analysisService.create(AnalysisUtil.create());
    }
}