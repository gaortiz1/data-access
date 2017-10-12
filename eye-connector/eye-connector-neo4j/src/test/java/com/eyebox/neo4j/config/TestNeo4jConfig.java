package com.eyebox.neo4j.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.eyebox.neo4j.repositories"})
public class TestNeo4jConfig {
}
