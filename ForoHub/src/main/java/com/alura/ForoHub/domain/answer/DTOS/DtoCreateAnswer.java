package com.alura.ForoHub.domain.answer.DTOS;

import jakarta.validation.constraints.NotNull;

public record DtoCreateAnswer(
        @NotNull
        String message,
        @NotNull
        Long idAutor,
        @NotNull
        Long idTopic
) {}