package com.Upcoming.Events.demo.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class StaticResourceController {

    @GetMapping(value = "/static/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) throws IOException {
        Path path = Paths.get("src/main/resources/static/" + filename);
        Resource resource = new ClassPathResource(path.toString());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }
}

