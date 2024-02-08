package org.bamburov;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;

@RestController
public class Controller {
    @PostMapping("write/{ticker}")
    public ResponseEntity<String> write(@PathVariable String ticker, @RequestBody String body) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("data/" + ticker + ".json"));
        writer.write(body);

        writer.close();
        return ResponseEntity.status(HttpStatus.OK).body("{\"result\": \"OK\"}");
    }
}
