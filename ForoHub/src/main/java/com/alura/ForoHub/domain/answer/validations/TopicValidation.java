package com.alura.ForoHub.domain.answer.validations;

import com.alura.ForoHub.domain.answer.DTOS.DtoCreateAnswer;
import com.alura.ForoHub.domain.topic.TopicRepository;
import com.alura.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicValidation implements AnswerValidation{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DtoCreateAnswer dtoCreateAnswer) {
        if (topicRepository.findById(dtoCreateAnswer.idTopic()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un topico con este id");
        }
    }
}