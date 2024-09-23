package com.emanueldias.docker_manager.controller;

import com.emanueldias.docker_manager.service.DockerClientService;
import com.github.dockerjava.api.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/containers")
public class DockerContainersController {


    private final DockerClientService dockerClientService;

    public DockerContainersController(DockerClientService dockerClientService) {
        this.dockerClientService = dockerClientService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Container>> getAllContainers(){
        return ResponseEntity.ok(dockerClientService.listAllContainers());
    }

    @GetMapping("/actives")
    public ResponseEntity<List<Container>> getAllContainersActivates(){
        return ResponseEntity.ok(dockerClientService.listAllContainersActives());
    }

    @PostMapping("/start/{containerId}")
    public ResponseEntity startContainer(@PathVariable String containerId){
        dockerClientService.startContainer(containerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/stop/{containerId}")
    public ResponseEntity stopContainer(@PathVariable String containerId){
        dockerClientService.stopContairner(containerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create/{image}")
    public ResponseEntity createContainer(@PathVariable String image){
        dockerClientService.createContainer(image);
        return ResponseEntity.created(null).body(null);
    }

    @DeleteMapping("/delete/{containerId}")
    public ResponseEntity deleteContainer(@PathVariable String containerId){
        dockerClientService.deleteContainer(containerId);
        return ResponseEntity.noContent().build();
    }
}
