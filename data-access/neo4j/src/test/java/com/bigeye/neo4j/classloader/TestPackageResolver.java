package com.bigeye.neo4j.classloader;


import java.util.Collections;
import java.util.Set;

public class TestPackageResolver implements PackageResolver {

    @Override
    public Set<String> getPackages() {
        return Collections.singleton("com.bigeye.neo4j.entity");
    }
}
