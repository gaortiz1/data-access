package com.bigeye.neo4j.classloader;


public class TestConfigResolver implements ConfigResolver {
    @Override
    public String getDriverClassName() {
        return "org.neo4j.ogm.drivers.bolt.driver.BoltDriver";
    }

    @Override
    public String getUsername() {
        return "neo4j";
    }

    @Override
    public String getPassword() {
        return "Hotmail.com";
    }

    @Override
    public String getURI() {
        return "bolt://localhost";
    }
}
