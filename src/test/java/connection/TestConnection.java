package connection;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Oleg Romanenchuk
 */
public class TestConnection extends DatabaseTestCase{

    private static Logger log = Logger.getLogger(TestConnection.class);

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33033/workspace", "root", "root");
        log.info("connected " + connection);
        return new DatabaseConnection(connection);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return null;
    }


}
