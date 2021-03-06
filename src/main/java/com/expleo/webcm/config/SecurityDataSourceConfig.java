package com.expleo.webcm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Contains the configuration of connection to webcm_security schema.
 * */
@Configuration
@PropertySource("classpath:loginsecurity-mysql.properties")
public class SecurityDataSourceConfig {

    //set up variable to hold the properties
    @Autowired
    private Environment env;

    //set up a logger for diag
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Bean(name = "securityDataSource")
    @Primary
    public DataSource securityDataSource() {

        //create a connection pool
        ComboPooledDataSource securityDataSource =
                new ComboPooledDataSource();

        //set jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("logsec.jdbc.driver"));
            myLogger.info("================= logsec.jdbc.driver--- set====================");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection props
        myLogger.info(">>>> logsec.jdbc.url = " + env.getProperty("logsec.jdbc.url"));
        myLogger.info(">>>> logsec.jdbc.user = " + env.getProperty("logsec.jdbc.user"));

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("logsec.jdbc.url"));
        securityDataSource.setUser(env.getProperty("logsec.jdbc.user"));
        securityDataSource.setPassword(env.getProperty("logsec.jdbc.password"));


        //set connection pool props

        securityDataSource.setInitialPoolSize(
                getIntProperty("logsec.connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(
                getIntProperty("logsec.connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("logsec.connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("logsec.connection.pool.maxIdleTime"));
        securityDataSource.setAcquireIncrement(getIntProperty("logsec.connection.pool.acquireIncrement"));



        return securityDataSource;
    }

    private Properties getSecurityHibernateProperties() {

        //set hibernate props
        Properties props = new Properties();

        props.setProperty("logsec.javax.persistence.validation.mode",
                env.getProperty("logsec.javax.persistence.validation.mode"));
        props.setProperty("hibernate.dialect", env.getProperty("logsec.hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("logsec.hibernate.show_sql"));

        return props;
    }

    @Bean(name = "sessionSecurityFactory")
    public LocalSessionFactoryBean sessionSecurityFactory() {

        //create session factory
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        //set props
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("logsec.hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getSecurityHibernateProperties());

        return sessionFactory;
    }

    //--------------------HELPER--------------------
    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);

        //convert to int
        return Integer.parseInt(propVal);
    }
}
