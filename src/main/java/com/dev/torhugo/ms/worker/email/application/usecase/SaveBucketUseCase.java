package com.dev.torhugo.ms.worker.email.application.usecase;

import com.dev.torhugo.ms.worker.email.application.repository.BucketRepository;
import com.dev.torhugo.ms.worker.email.domain.entity.BucketError;
import com.dev.torhugo.ms.worker.email.infrastructure.dto.BucketErroDTO;

import java.util.logging.Logger;

public class SaveBucketUseCase {
    private final Logger log = Logger.getLogger(getClass().getName());
    private final BucketRepository bucketRepository;

    public SaveBucketUseCase(final BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    public void execute(final BucketErroDTO input){
        log.info("Executing usecase: SaveBucket().");
        final var bucket = BucketError.create(
                input.process(),
                input.error(),
                input.identifier()
        );
        bucketRepository.save(bucket);
    }
}
