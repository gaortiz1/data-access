package com.eyebox.neo4j.repositories;

import com.eyebox.neo4j.entity.Movie;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository extends AbstractNeo4jRepository <Movie> {

    public MovieRepository(Session session) {
        super(Movie.class, session);
    }
}
