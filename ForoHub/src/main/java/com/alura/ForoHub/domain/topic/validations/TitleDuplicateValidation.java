package com.alura.ForoHub.domain.topic.validations;

import com.alura.ForoHub.domain.topic.DTOS.DtoRegisterTopic;
import com.alura.ForoHub.domain.topic.Topic;
import com.alura.ForoHub.domain.topic.TopicRepository;
import com.alura.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TitleDuplicateValidation implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        Optional<Topic> topic = topicRepository.findByTitle(dtoRegisterTopic.title());

        if (topic.isPresent()) {
            throw new IntegrityValidation("Ya existe un topico con este mismo titulo");
        }
    }
}
