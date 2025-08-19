package com.alura.ForoHub.domain.answer;

import com.alura.ForoHub.domain.answer.DTOS.DtoCreateAnswer;
import com.alura.ForoHub.domain.answer.DTOS.DtoListAnswers;
import com.alura.ForoHub.domain.answer.validations.AnswerValidation;
import com.alura.ForoHub.domain.profile.Profile;
import com.alura.ForoHub.domain.profile.ProfileRepository;
import com.alura.ForoHub.domain.topic.Topic;
import com.alura.ForoHub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateAnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private List<AnswerValidation> answerValidationList;

    public DtoListAnswers create(DtoCreateAnswer dtoCreateAnswer) {
        // validations
        answerValidationList.forEach(v -> v.validate(dtoCreateAnswer));
        // relations
        Profile profile = profileRepository.findById(dtoCreateAnswer.idAutor()).get();
        Topic topic = topicRepository.findById(dtoCreateAnswer.idTopic()).get();
        // instance..
        LocalDateTime creationDate = LocalDateTime.now();
        Answer answer = new Answer(null, dtoCreateAnswer.message(), creationDate, false, true, profile, topic);
        answerRepository.save(answer);
        return new DtoListAnswers(answer);
    }
}
