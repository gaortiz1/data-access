package com.eyebox.neo4j.configuration;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Neo4jConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class TestNeo4jConfiguration {

    @Autowired
    private Session session;

    @Test
    public void shouldGetSession() {
        Assert.assertNotNull(session);
    }

}
