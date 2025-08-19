package com.alura.ForoHub.domain.topic.validations;

import com.alura.ForoHub.domain.course.CourseRepository;
import com.alura.ForoHub.domain.topic.DTOS.DtoRegisterTopic;
import com.alura.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidation implements TopicValidator{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (courseRepository.findById(dtoRegisterTopic.idCourse()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un curso con este id");
        }
    }
}
