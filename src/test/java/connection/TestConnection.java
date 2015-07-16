package connection;

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
    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33033/workspace", "root", "root");
        return new DatabaseConnection(connection);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return null;
    }


}
