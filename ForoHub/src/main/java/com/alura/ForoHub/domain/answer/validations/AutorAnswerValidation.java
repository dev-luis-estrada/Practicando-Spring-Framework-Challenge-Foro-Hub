package com.alura.ForoHub.domain.answer.validations;

import com.alura.ForoHub.domain.answer.DTOS.DtoCreateAnswer;
import com.alura.ForoHub.domain.profile.ProfileRepository;
import com.alura.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AutorAnswerValidation implements AnswerValidation{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void validate(DtoCreateAnswer dtoCreateAnswer) {
        if (profileRepository.findById(dtoCreateAnswer.idAutor()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un perfil con este id");
        }
    }
}