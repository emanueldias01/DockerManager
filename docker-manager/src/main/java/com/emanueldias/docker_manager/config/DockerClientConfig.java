package com.emanueldias.docker_manager.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.RemoteApiVersion;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {
    @Value("${docker.path}")
    private String dockerPath;

    @Bean
    public DockerClient buildDockerClient() {
        DefaultDockerClientConfig.Builder dockerClientConfigBuilder = DefaultDockerClientConfig
                .createDefaultConfigBuilder();

        if (this.dockerPath != null && this.dockerPath.startsWith("tcp://")) {
            dockerClientConfigBuilder.withDockerHost(dockerPath)
                    .withApiVersion(RemoteApiVersion.VERSION_1_24)
                    .withDockerTlsVerify(false);
        }

        DefaultDockerClientConfig dockerClientConfig = dockerClientConfigBuilder.build();

        ApacheDockerHttpClient apacheDockerHttpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(dockerClientConfig.getDockerHost()).build();

        return DockerClientBuilder.getInstance(dockerClientConfig).withDockerHttpClient(apacheDockerHttpClient).build();

    }
}
