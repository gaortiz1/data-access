package com.bigeye.neo4j.context;

import com.bigeye.neo4j.configuration.Neo4jConfiguration;
import org.neo4j.ogm.session.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Neo4jContext {

    private static final ApplicationContext APPLICATION_CONTEXT;

    static {
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(Neo4jConfiguration.class);
    }

    public Session getSession() {
        return APPLICATION_CONTEXT.getBean(Session.class);
    }
}
