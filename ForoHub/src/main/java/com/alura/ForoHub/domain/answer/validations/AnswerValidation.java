package com.alura.ForoHub.domain.answer.validations;

import com.alura.ForoHub.domain.answer.DTOS.DtoCreateAnswer;

public interface AnswerValidation {
    void validate(DtoCreateAnswer dtoCreateAnswer);
}
