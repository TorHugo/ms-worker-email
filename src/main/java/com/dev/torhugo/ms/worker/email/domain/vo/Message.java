package com.dev.torhugo.ms.worker.email.domain.vo;

public record Message(
        String subject,
        String introduction,
        String body,
        String conclusion,
        String signature
) {
    public String getMessage(){
        return introduction +
                body +
                conclusion +
                signature;
    };
}
