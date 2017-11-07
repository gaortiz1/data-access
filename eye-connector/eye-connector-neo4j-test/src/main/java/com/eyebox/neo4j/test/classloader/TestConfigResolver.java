package com.eyebox.neo4j.test.classloader;


import com.eyebox.neo4j.classloader.ConfigResolver;

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
        return "file:///var/tmp/neo4j.db";
    }
}
