package com.alura.ForoHub.domain.topic;

import com.alura.ForoHub.domain.course.Course;
import com.alura.ForoHub.domain.course.CourseRepository;
import com.alura.ForoHub.domain.profile.Profile;
import com.alura.ForoHub.domain.profile.ProfileRepository;
import com.alura.ForoHub.domain.topic.DTOS.DtoRegisterTopic;
import com.alura.ForoHub.domain.topic.DTOS.DtoTopicList;
import com.alura.ForoHub.domain.topic.validations.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateTopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    List<TopicValidator> validatorList;

    public DtoTopicList create(DtoRegisterTopic dtoRegisterTopic) {
        // validations
        validatorList.forEach(v -> v.validate(dtoRegisterTopic));
        // relations
        Profile profile = profileRepository.findById(dtoRegisterTopic.idAutor()).get();
        Course course = courseRepository.findById(dtoRegisterTopic.idCourse()).get();
        // instance of topic
        LocalDateTime creationDate = LocalDateTime.now();
        Topic topic = new Topic(null, dtoRegisterTopic.title(), dtoRegisterTopic.message(), creationDate, false, true, null, profile, course);
        topicRepository.save(topic);

        return new DtoTopicList(topic);
    }
}
