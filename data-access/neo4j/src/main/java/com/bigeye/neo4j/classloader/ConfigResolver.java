package com.bigeye.neo4j.classloader;


public interface ConfigResolver {

    String getDriverClassName();

    String getUsername();

    String getPassword();

    String getURI();
}
