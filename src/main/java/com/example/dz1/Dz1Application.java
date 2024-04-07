package com.example.dz1;

import com.example.dz1.config.minio.MinioProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties(MinioProperties.class)
@EnableJpaRepositories
@EnableJpaAuditing
@EnableCaching
public class Dz1Application {

    public static void main(String[] args) {
        SpringApplication.run(Dz1Application.class, args);
    }

}
