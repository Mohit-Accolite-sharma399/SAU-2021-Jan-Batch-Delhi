package com.assignment.kafka.springbootwithkafka.engine;

import com.assignment.kafka.springbootwithkafka.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, Movie> kafkaTemplate;

    public void sendMovie(String movieName, int year, String genre, String actor) {
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setYear(year);
        movie.setGenre(genre);
        movie.setActor(actor);
        logger.info(String.format("#### -> Producing message -> %s", movie));
        this.kafkaTemplate.send(TOPIC, movie);
    }
}