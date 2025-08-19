package com.alura.ForoHub.domain.topic.validations;

import com.alura.ForoHub.domain.topic.DTOS.DtoRegisterTopic;

public interface TopicValidator {
    void validate(DtoRegisterTopic dtoRegisterTopic);
}
