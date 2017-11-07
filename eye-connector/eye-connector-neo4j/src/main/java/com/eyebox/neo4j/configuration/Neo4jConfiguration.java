package com.eyebox.neo4j.configuration;

import com.eyebox.neo4j.classloader.ConfigResolver;
import com.eyebox.neo4j.service.ConfigurationService;
import com.eyebox.neo4j.service.PackageService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.neo4j.conversion.MetaDataDrivenConversionService;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Neo4jConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), PackageService.load());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        final ConfigResolver configResolver = ConfigurationService.load();
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(configResolver.getURI())
                .credentials(configResolver.getUsername(), configResolver.getPassword())
                .build();
        return configuration;
    }

    @Bean
    public ConversionService conversionService() {
        return new MetaDataDrivenConversionService(sessionFactory().metaData());
    }

    @Bean
    public Session session() {
        return sessionFactory().openSession();
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
