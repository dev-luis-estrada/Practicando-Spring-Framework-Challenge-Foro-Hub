package com.alura.ForoHub.domain.profile.DTOS;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateProfile(
        @NotNull
        Long id,
        String name,
        String email
) { }
