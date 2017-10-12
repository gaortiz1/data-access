package com.eyebox.neo4j.test;


import com.eyebox.neo4j.configuration.Neo4jConfiguration;

import com.eyebox.neo4j.test.config.TestNeo4jConfig;
import com.eyebox.neo4j.test.entity.Movie;
import com.eyebox.neo4j.test.entity.Person;
import com.eyebox.neo4j.test.entity.Role;
import com.eyebox.neo4j.test.repositories.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Neo4jConfiguration.class, TestNeo4jConfig.class}, loader = AnnotationConfigContextLoader.class)
public class TestMovieRepository {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldCreateMovie() {
        Person person = new Person("Paul Walker");
        Movie movie = new Movie("fast and furious 5", 5);
        movie.addRole(new Role(movie, person));
        this.movieRepository.create(movie, 2);
    }
}
