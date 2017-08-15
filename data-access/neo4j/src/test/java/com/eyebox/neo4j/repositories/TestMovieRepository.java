package com.eyebox.neo4j.repositories;


import com.eyebox.neo4j.configuration.Neo4jConfiguration;
import com.eyebox.neo4j.entity.Movie;
import com.eyebox.neo4j.entity.Person;
import com.eyebox.neo4j.entity.Role;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.ogm.session.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Ignore
public class TestMovieRepository {

    private MovieRepository movieRepository;

    @Before
    public void init() {
        this.movieRepository = new MovieRepository(new AnnotationConfigApplicationContext(Neo4jConfiguration.class).getBean(Session.class));
    }

    @Test
    public void shouldCreateMovie() {
        Person person = new Person("Paul Walker");
        Movie movie = new Movie("fast and furious 5", 5);
        movie.addRole(new Role(movie, person));
        this.movieRepository.create(movie, 2);
    }
}
