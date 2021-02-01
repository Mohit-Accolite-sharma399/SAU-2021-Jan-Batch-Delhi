package com.assignment.kafka.springbootwithkafka.controllers;

import com.assignment.kafka.springbootwithkafka.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/movie")
    public void sendMessageToKafkaTopic(@RequestParam("movieName") String movieName, @RequestParam("year") int year,
                                        @RequestParam("genre") String genre, @RequestParam("actor") String actor) {
        //this.producer.sendMessage(message);
        this.producer.sendMovie(movieName, year, genre ,actor);
    }
}

