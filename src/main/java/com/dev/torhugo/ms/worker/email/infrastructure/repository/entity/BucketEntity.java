package com.dev.torhugo.ms.worker.email.infrastructure.repository.entity;

import com.dev.torhugo.ms.worker.email.domain.entity.BucketError;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity(name = "bucket_tb")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class BucketEntity {
    @Id
    private UUID bucketId;
    private String process;
    private String application;
    private String identifier;
    private String error;
    private LocalDateTime createdAt;

    public static BucketEntity fromAggregate(final BucketError domain){
        return new BucketEntity(
                domain.getBucketId(),
                domain.getProcess(),
                domain.getApplication(),
                domain.getIdentifier(),
                domain.getError(),
                domain.getCreatedAt()
        );
    }
}
