package com.alura.ForoHub.domain.profile.DTOS;

import java.util.List;

public record DtoListProfile(
        Long id,
        String nombre,
        String email,
        List<String> topicos
){}
