package com.dev.torhugo.ms.worker.email.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailDTO(
        @JsonProperty("email") String emailTo
) {
}
