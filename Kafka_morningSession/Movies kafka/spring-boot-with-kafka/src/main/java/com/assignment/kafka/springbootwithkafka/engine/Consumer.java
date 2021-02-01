package com.assignment.kafka.springbootwithkafka.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.assignment.kafka.springbootwithkafka.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class Consumer {

    HashMap<Integer, HashMap<String, Integer>> trackTrending = new HashMap<Integer, HashMap<String, Integer>>();
    HashMap<Integer, String> topTrending = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        Movie movie = new ObjectMapper().readValue(message, Movie.class);

        HashMap<String, Integer> m = new HashMap<>();
        if(trackTrending.containsKey(movie.getYear())) {
            m=trackTrending.get(movie.getYear());
            m.put(movie.getActor(), m.containsKey(movie.getActor()) ? m.get(movie.getActor()) + 1 : 1);
            if(m.get(movie.getActor())>=m.get(topTrending.get(movie.getYear())))
            {
                topTrending.put(movie.getYear(), movie.getActor());
            }
        }
        else {
            topTrending.put(movie.getYear(), movie.getActor());
            m.put(movie.getActor(),1);
        }
        trackTrending.put(movie.getYear(),m);
        logger.info(String.format("#### -> Consumed message -> %s", message));
        logger.info(String.format("Top Trending Actor of "+ movie.getYear() + " is " + topTrending.get(movie.getYear())));
    }
}