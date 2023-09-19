package hangtum.store.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hangtum.store.cart.model.Lesson;
import hangtum.store.cart.repository.LessonRepository;

@Service
public class LessonControllerService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonControllerService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLesson() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons;
    }

    public Optional<Lesson> getLessonById(Long id) {
        Optional<Lesson> optLesson = lessonRepository.findById(id);
        return optLesson;
    }

    public List<Lesson> getLessonByCourseID(String courseID) {
        List<Lesson> lessons = lessonRepository.findByCourseID(courseID);
        return lessons;
    }

    public void saveLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public void deleteAllLesson() {
        lessonRepository.deleteAll();
    }
}
