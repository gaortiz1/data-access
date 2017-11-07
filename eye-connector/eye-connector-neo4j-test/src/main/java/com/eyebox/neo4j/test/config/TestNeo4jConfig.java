package com.eyebox.neo4j.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.eyebox.neo4j.test"})
public class TestNeo4jConfig {

//    @Bean(destroyMethod = "shutdown")
//    public GraphDatabaseService graphDatabaseService() {
//        GraphDatabaseService graphDatabaseService = new GraphDatabaseFactory()
//                .newEmbeddedDatabaseBuilder(new File("target/graph.db"))
//                .setConfig(GraphDatabaseSettings.forbid_shortestpath_common_nodes, "false")
//                .newGraphDatabase();
//
//        return graphDatabaseService;
//    }

}
