package com.dev.torhugo.ms.worker.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueueWorkerMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueueWorkerMailApplication.class, args);
    }

}
