package com.example.user.userdemo.config;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerfactoryBean",
        basePackages = "com.example.user.userdemo.repo",
        transactionManagerRef = "secondTransactionManager"
)
public class CourseConfig {

    private Environment environment;

    //Datasource Bean

    @Bean(name="secondDataSource")
   // @Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pocdb");
        //dataSource.setDriverClassName(environment.getProperties().getProperty("spring.datasource.driver-class-name"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }

    //EntityManagerFactory

    @Bean(name="secondEntityManagerfactoryBean")
    //@Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());

        Map<String, String> props=new HashMap<>();

        props.put("spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        props.put("spring.jpa.show-sql","true");
        props.put("spring.jpa.hibernate.ddl-auto","update");
        JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        bean.setJpaPropertyMap(props);
        bean.setPackagesToScan("com.example.user.userdemo.entity1");

        return bean;
    }

    //PlateformTransactionManager
    @Bean(name="secondTransactionManager")
    //@Primary
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }
}
