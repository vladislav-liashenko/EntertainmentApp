package com.entertainmentApp.config;

import com.entertainmentApp.domain.entertainment.Category;
import com.entertainmentApp.domain.entertainment.Entertainment;
import com.entertainmentApp.domain.user.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("com.entertainmentApp.dao"),
        @ComponentScan("com.entertainmentApp.service")
})
public class HibernateConfig {

    @Autowired
    private Environment env;
//b
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put("hibernate.show_sql", Objects.requireNonNull(env.getProperty("hibernate.show_sql")));
        properties.put("hibernate.hbm2ddl.auto", Objects.requireNonNull(env.getProperty("hibernate.hbm2ddl.auto")));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class, Entertainment.class, Category.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
