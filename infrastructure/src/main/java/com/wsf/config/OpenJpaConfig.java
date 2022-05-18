package com.wsf.config;

import com.wsf.jpa.repository.EnhanceJpaRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * open
 * SoulLose
 * 2022-05-16 14:35
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = OpenJpaConfig.REPOSITORY_PACKAGE,
        entityManagerFactoryRef = "openEntityManagerFactory",
        transactionManagerRef = "openTransactionManager",
        repositoryBaseClass = EnhanceJpaRepositoryImpl.class
)
public class OpenJpaConfig {
    
    public OpenJpaConfig() {}
    
    public static final String REPOSITORY_PACKAGE = "com.wsf.**";
    
    @Primary
    @Bean(name = "openEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean openEntityManagerFactory(@Qualifier(value = "openDataSource") DataSource openDataSource,
                                                                           JpaProperties jpaProperties,
                                                                           EntityManagerFactoryBuilder builder) {
        return builder.dataSource(openDataSource).properties(jpaProperties.getProperties()).packages(REPOSITORY_PACKAGE).persistenceUnit("openDS").build();
    }
    
//    public JpaTransactionManager
    @Primary
    @Bean(name = "openTransactionManager")
    public JpaTransactionManager openTransactionManager(@Qualifier(value = "openEntityManagerFactory")EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
