package com.example.dz1.config.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration {

    @Bean
    public MinioClient minioClient(MinioProperties properties) throws Exception {
        MinioClient client = MinioClient.builder()
                .credentials(
                        properties.getAccessKey(),
                        properties.getSecretKey())
                .endpoint(
                        properties.getUrl(),
                        properties.getPort(),
                        properties.isSecure())
                .build();

        if (!client.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(properties.getBucket())
                        .build())) {

            client.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(properties.getBucket())
                            .build()
            );
        }

        return client;
    }

}
