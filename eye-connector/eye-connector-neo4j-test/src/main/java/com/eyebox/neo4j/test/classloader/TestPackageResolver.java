package com.eyebox.neo4j.test.classloader;


import com.eyebox.neo4j.classloader.PackageResolver;

import java.util.Collections;
import java.util.Set;

public class TestPackageResolver implements PackageResolver {

    @Override
    public Set<String> getPackages() {
        return Collections.singleton("com.eyebox.neo4j.entity");
    }
}
