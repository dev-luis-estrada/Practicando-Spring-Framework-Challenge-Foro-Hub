package com.alura.ForoHub.domain.topic.validations;

import com.alura.ForoHub.domain.profile.ProfileRepository;
import com.alura.ForoHub.domain.topic.DTOS.DtoRegisterTopic;
import com.alura.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValidation implements TopicValidator{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (profileRepository.findById(dtoRegisterTopic.idAutor()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un perfil con este id");
        }
    }
}
