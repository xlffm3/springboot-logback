package com.practice.logging.presentation;

import com.practice.logging.domain.User;
import com.practice.logging.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EventController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/exception")
    public ResponseEntity<Void> throwException() {
        userRepository.save(new User("abc"));
        log.error("ghihhihi");
        throw new IllegalArgumentException();
    }

    @GetMapping("/normal")
    public ResponseEntity<String> proceed() {
        return ResponseEntity.ok("this is normal processor");
    }
}
