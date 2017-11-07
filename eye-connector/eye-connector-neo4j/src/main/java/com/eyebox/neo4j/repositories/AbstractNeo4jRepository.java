package com.eyebox.neo4j.repositories;


import com.eyebox.neo4j.api.Neo4jRepository;
import org.neo4j.ogm.session.Session;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractNeo4jRepository <Entity extends Serializable> implements Neo4jRepository <Entity, Long> {

    private static final int DEFAULT_DEPTH = 0;

    protected final Session session;
    protected final Class<Entity> entityClass;

    protected AbstractNeo4jRepository(Class<Entity> entityClass, Session session) {
        this.entityClass = entityClass;
        this.session = session;
    }

    @Override
    public Entity create(Entity entity) {
        return this.create(entity, DEFAULT_DEPTH);
    }

    @Override
    public Entity create(Entity entity, int depth) {
        this.session.save(entity, depth);
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        return this.update(entity, DEFAULT_DEPTH);
    }

    @Override
    public Entity update(Entity entity, int depth) {
        this.session.save(entity, depth);
        return entity;
    }

    @Override
    public Entity findById(Long id) {
        return this.findById(id, DEFAULT_DEPTH);
    }

    @Override
    public Entity findById(Long id, int depth) {
        return this.session.load(this.entityClass, id, depth);
    }

    @Override
    public List<Entity> findAll() {
        return this.findAll(DEFAULT_DEPTH);
    }

    @Override
    public List<Entity> findAll(int depth) {
        return (List<Entity>) this.session.loadAll(this.entityClass, depth);
    }
}
