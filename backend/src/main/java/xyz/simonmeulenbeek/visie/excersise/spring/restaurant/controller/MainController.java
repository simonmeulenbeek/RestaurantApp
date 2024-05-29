package xyz.simonmeulenbeek.visie.excersise.spring.restaurant.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @CrossOrigin
    @GetMapping("/")
    public Resource index() {
        return new ClassPathResource("public/index.html");
    }
}
