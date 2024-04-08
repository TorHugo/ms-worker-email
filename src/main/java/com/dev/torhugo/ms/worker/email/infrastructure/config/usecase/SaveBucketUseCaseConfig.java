package com.dev.torhugo.ms.worker.email.infrastructure.config.usecase;

import com.dev.torhugo.ms.worker.email.application.repository.BucketRepository;
import com.dev.torhugo.ms.worker.email.application.usecase.SaveBucketUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveBucketUseCaseConfig {
    private final BucketRepository bucketRepository;
    @Bean
    public SaveBucketUseCase saveBucketUseCase(){
        return new SaveBucketUseCase(bucketRepository);
    }
}
