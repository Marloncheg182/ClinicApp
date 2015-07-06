package clinicapp.Dao.Service;

import clinicapp.entity.Analysis;
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

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AnalysisServiceImplTest extends DBUnitConfig {

    private AnalysisServiceImpl analysisService = new AnalysisServiceImpl();
    private EntityManager manager = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public AnalysisServiceImplTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/analysis/analysis-data.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testCreate() throws Exception {
        Analysis analysis = new Analysis();
        analysis.setDate("12.06.15");
        analysis.setNotes("general inspection: some problems with heart rhythm");

        analysisService.create(analysis);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/analysis/analysis-create.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "analysis", ignore);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Analysis> clinics = analysisService.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("test.conf/analysis/analysis-data.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("analysis").getRowCount(), clinics.size());
    }
}