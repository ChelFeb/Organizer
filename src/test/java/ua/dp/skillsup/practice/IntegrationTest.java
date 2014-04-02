package ua.dp.skillsup.practice;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-placeholder.xml", "classpath*:../webapp/WEB-INF/applicationContext.xml",
        "classpath*:dataSource.xml"})
@Transactional
public abstract class IntegrationTest extends
        AbstractTransactionalJUnit4SpringContextTests {

    protected static final Properties prop = new Properties();

    static {
        try {
            prop.load(new InputStreamReader(IntegrationTest.class.getResourceAsStream("/test-config.properties")));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void initializeData() throws RuntimeException {
        try {
            Class.forName(prop.getProperty("jdbc.driverClassName")).newInstance();
            final Connection connection = DriverManager.getConnection(
                    prop.getProperty("jdbc.databaseUrl"),
                    prop.getProperty("jdbc.username"),
                    prop.getProperty("jdbc.password"));
            final HsqldbConnection dbunitConnection = new HsqldbConnection(connection, null);
            final InputStream is = IntegrationTest.class.getResourceAsStream("/test-data.xml");
            final IDataSet dataSet = new XmlDataSet(is);
            DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, dataSet);
            dbunitConnection.close();
            connection.close();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}