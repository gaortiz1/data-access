package com.eyebox.neo4j.configuration;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.ogm.session.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Ignore
public class TestNeo4jConfiguration {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        this.applicationContext =  new AnnotationConfigApplicationContext(Neo4jConfiguration.class);
    }

    @Test
    public void shouldGetSession() {
        Session session = this.applicationContext.getBean(Session.class);
        Assert.assertNotNull(session);
    }

}
