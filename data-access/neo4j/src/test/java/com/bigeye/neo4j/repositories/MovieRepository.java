package com.bigeye.neo4j.repositories;

import com.bigeye.neo4j.entity.Movie;
import org.neo4j.ogm.session.Session;


public class MovieRepository extends AbstractNeo4jRepository <Movie> {

    public MovieRepository(Session session) {
        super(Movie.class, session);
    }
}