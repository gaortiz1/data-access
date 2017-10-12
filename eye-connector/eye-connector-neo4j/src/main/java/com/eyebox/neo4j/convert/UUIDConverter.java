package com.eyebox.neo4j.convert;

import org.apache.commons.lang3.StringUtils;
import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID, String> {

    @Override
    public String toGraphProperty(UUID uuid) {
        return null != uuid ? uuid.toString() : null;
    }

    @Override
    public UUID toEntityAttribute(String value) {
        return StringUtils.isNotBlank(value) ? UUID.fromString(value) : null;
    }
}
