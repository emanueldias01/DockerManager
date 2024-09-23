package com.emanueldias.docker_manager.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

import java.util.List;


public class DockerClientService {

    private final DockerClient dockerClient;

    public DockerClientService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }


    public List<Container> listAllContainers(){
        return dockerClient.listContainersCmd().withShowAll(true).exec();
    }

    public List<Container> listAllContainersActives(){
        return dockerClient.listContainersCmd().withShowAll(false).exec();
    }

    public List<Image> listAllImages(){
        return dockerClient.listImagesCmd().exec();
    }

    public void startContainer(String containerId){
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContairner(String containerId){
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void createContainer(String image){
        dockerClient.createContainerCmd(image);
    }

    public void deleteContainer(String containerId){
        dockerClient.removeContainerCmd(containerId);
    }
}
