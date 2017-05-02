package WebApi.webAppConfig;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@ComponentScan({"WebApi"})
@EnableTransactionManagement
public class HibernateConfig {
    @Autowired
    private Environment environment;

    @Bean(name = "Session")
    public LocalSessionFactoryBean SessionFactory () throws URISyntaxException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.art.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return  sessionFactory;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernet.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.autocommit","true");
        properties.put("connection.autoReconnect=true","true");
        properties.put("hibernate.autoReconnect","true");
        properties.put("hibernate.connection.pool_size=","10");
        return properties;
    }

        @Bean
        public BasicDataSource dataSource() throws URISyntaxException {
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            String username = System.getenv("JDBC_DATABASE_USERNAME");
            String password = System.getenv("JDBC_DATABASE_PASSWORD");

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(dbUrl);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            return basicDataSource;
        }


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s ) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager ;
    }
}
