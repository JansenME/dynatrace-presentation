package com.testapp.demo.controller;

import com.testapp.demo.model.Number;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/generateNumber")
    public ResponseEntity<Number> getEndpoint(){
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 11);

        if(randomNumber == 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(randomNumber == 5) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }

        if(randomNumber == 8) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }

        com.testapp.demo.model.Number number = new com.testapp.demo.model.Number(randomNumber);

        return ResponseEntity.ok(number);
    }
}
