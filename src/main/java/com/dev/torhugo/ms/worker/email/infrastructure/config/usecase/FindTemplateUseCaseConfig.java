package com.dev.torhugo.ms.worker.email.infrastructure.config.usecase;

import com.dev.torhugo.ms.worker.email.application.repository.TemplateRepository;
import com.dev.torhugo.ms.worker.email.application.usecase.FindTemplateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FindTemplateUseCaseConfig {
    private final TemplateRepository templateRepository;
    @Bean
    public FindTemplateUseCase findTemplateUseCase(){
        return new FindTemplateUseCase(templateRepository);
    }
}
