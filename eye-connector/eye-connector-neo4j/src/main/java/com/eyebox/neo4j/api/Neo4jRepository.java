package com.eyebox.neo4j.api;


import java.io.Serializable;
import java.util.List;

public interface Neo4jRepository <Entity extends Serializable, Id extends Serializable> {

    Entity create(Entity entity, int depth);

    Entity create(Entity entity);

    Entity update(Entity entity, int depth);

    Entity update(Entity entity);

    Entity findById(Id id, int depth);

    Entity findById(Id id);

    List<Entity> findAll(int depth);

    List<Entity> findAll();

}
