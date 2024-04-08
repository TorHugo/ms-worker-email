package com.dev.torhugo.ms.worker.email.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForgetPasswordDTO(
        @JsonProperty("email") String emailTo,
        @JsonProperty("hash_code") String hash,
        @JsonProperty("expiration_date") String expirationDate
) {
}
