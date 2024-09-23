package com.emanueldias.docker_manager.controller;

import com.emanueldias.docker_manager.service.DockerClientService;
import com.github.dockerjava.api.model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class DockerImagesController {

    private final DockerClientService dockerClientService;

    public DockerImagesController(DockerClientService dockerClientService){
        this.dockerClientService = dockerClientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImages(){
        return ResponseEntity.ok(dockerClientService.listAllImages());
    }
}
