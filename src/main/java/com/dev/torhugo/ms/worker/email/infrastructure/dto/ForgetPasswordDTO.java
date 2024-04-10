package com.dev.torhugo.ms.worker.email.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForgetPasswordDTO(
        @JsonProperty("email") String emailTo,
        @JsonProperty("hash") String hash,
        @JsonProperty("expiration") String expirationDate
) {
}
