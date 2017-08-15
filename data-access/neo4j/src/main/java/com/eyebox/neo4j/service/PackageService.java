package com.eyebox.neo4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eyebox.neo4j.classloader.PackageResolver;
import org.apache.commons.collections4.CollectionUtils;
import org.neo4j.ogm.exception.ServiceNotFoundException;

import java.util.*;

public class PackageService {

    private static final Logger logger = LoggerFactory.getLogger(PackageService.class);

    private static ServiceLoader<PackageResolver> serviceLoader = ServiceLoader.load( PackageResolver.class );

    private PackageService(){}

    public static String[] load() {

        final Iterator<PackageResolver> iterator = serviceLoader.iterator();

        final Set<String> packages = new HashSet<>();

        while (iterator.hasNext()) {
            try {
                final PackageResolver packageResolver = iterator.next();
                final Set<String> newPackages = packageResolver.getPackages();

                if (CollectionUtils.isNotEmpty(newPackages))
                    packages.addAll(newPackages);

            } catch (ServiceConfigurationError sce) {
                logger.warn("{}, reason: {}", sce.getLocalizedMessage(), sce.getCause());
            }
        }

        if (CollectionUtils.isNotEmpty(packages))
            return packages.toArray(new String[]{});

        throw new ServiceNotFoundException("no package found for entities of type @NodeEntity");
    }

}
