package com.eyebox.neo4j.service;


import com.eyebox.neo4j.classloader.ConfigResolver;
import org.neo4j.ogm.exception.ServiceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class ConfigurationService {

    private static final Logger logger = LoggerFactory.getLogger(PackageService.class);

    private static ServiceLoader<ConfigResolver> serviceLoader = ServiceLoader.load(ConfigResolver.class);

    private ConfigurationService(){}

    public static ConfigResolver load() {

        final Iterator<ConfigResolver> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            try {

                final ConfigResolver configResolver = iterator.next();
                if (null != configResolver)
                    return configResolver;

            } catch (ServiceConfigurationError sce) {
                logger.warn("{}, reason: {}", sce.getLocalizedMessage(), sce.getCause());
            }
        }

        throw new ServiceNotFoundException("no ConfigResolver found ");
    }

}
