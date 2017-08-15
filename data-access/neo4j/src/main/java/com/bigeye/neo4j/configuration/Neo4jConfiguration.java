package com.bigeye.neo4j.configuration;

import com.bigeye.neo4j.classloader.ConfigResolver;
import com.bigeye.neo4j.service.ConfigurationService;
import com.bigeye.neo4j.service.PackageService;
import org.neo4j.ogm.authentication.UsernamePasswordCredentials;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.neo4j.conversion.MetaDataDrivenConversionService;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class Neo4jConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), PackageService.load());
    }

    @Bean
    public Configuration configuration() {

        final ConfigResolver configResolver = ConfigurationService.load();
        final Configuration config = new Configuration();
        config.driverConfiguration()
                .setDriverClassName(configResolver.getDriverClassName())
                .setCredentials(new UsernamePasswordCredentials(configResolver.getUsername(), configResolver.getPassword()))
                .setURI(configResolver.getURI());
        return config;
    }

    @Bean
    public ConversionService conversionService() {
        return new MetaDataDrivenConversionService(sessionFactory().metaData());
    }

    @Bean
    public Session session(){
        return sessionFactory().openSession();
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
