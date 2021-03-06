package clinicspdata.config;


import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration                                    // This class responds for Spring dbunitcase.config
@EnableTransactionManagement                      // Transactions in DBases are enabled
@ComponentScan("clinicspdata")                       // src for Spring components
@PropertySource("classpath:app.properties")       // properties
@EnableJpaRepositories("clinicspdata")    // enable the JPA repository in repository dir.
public class DataBeanConfig {

    private static final String PROP_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROP_DATABASE_URL = "jdbc:mysql://localhost:33033/workspace";
    private static final String PROP_DATABASE_USERNAME = "root";
    private static final String PROP_DATABASE_PASSWORD = "root";
    private static final String PROP_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "true";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "update";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "clinicspdata.entity";

    @Resource
    private Environment environment;           // uses to obtain our props. from app.properties

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource datSource = new DriverManagerDataSource();
        datSource.setDriverClassName(environment.getRequiredProperty(PROP_DATABASE_DRIVER));
        datSource.setUrl(environment.getRequiredProperty(PROP_DATABASE_URL));
        datSource.setUsername(environment.getRequiredProperty(PROP_DATABASE_USERNAME));
        datSource.setPassword(environment.getRequiredProperty(PROP_DATABASE_PASSWORD));
        return datSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(getHiberProperties());

        return entityManagerFactoryBean;
    }
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager();
    }

    private Properties getHiberProperties() {
        Properties props = new Properties();
        props.put(PROP_HIBERNATE_DIALECT, environment.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        props.put(PROP_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        props.put(PROP_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

        return props;
    }

}
