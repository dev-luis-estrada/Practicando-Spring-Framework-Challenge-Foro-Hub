package com.alura.ForoHub.domain.topic.DTOS;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateTopic(
        @NotNull
        Long id,
        String title,
        String message,
        Boolean status
) {
}
