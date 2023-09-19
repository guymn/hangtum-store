package hangtum.store.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hangtum.store.item.ServerMapper;
import hangtum.store.item.kafka.KafkaService;
import hangtum.store.item.model.Course;
import hangtum.store.item.model.CourseDTO;
import hangtum.store.item.repository.CourseRepository;

@Service
public class CourseControllerService {
    private final CourseRepository courseRepository;
    private final KafkaService kafkaService;
    private final ServerMapper serverMapper;

    @Autowired
    public CourseControllerService(CourseRepository courseRepository, KafkaService kafkaService,
            ServerMapper serverMapper) {
        this.courseRepository = courseRepository;
        this.kafkaService = kafkaService;
        this.serverMapper = serverMapper;
    }

    public List<Course> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public Optional<Course> getCourseById(Long id) {
        Optional<Course> optCourse = courseRepository.findById(id);
        return optCourse;
    }

    public List<Course> getCourseByCategoryID(String categoryID) {
        List<Course> courses = courseRepository.findByCategoryID(categoryID);
        return courses;
    }

    public List<Course> getCourseByTeacherID(String teacherID) {
        List<Course> courses = courseRepository.findByTeacherID(teacherID);
        return courses;
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void mapperCourse(CourseDTO courseDTO, Course course) {
        serverMapper.updateCourseFromDto(courseDTO, course);
        saveCourse(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void deleteAllCourse() {
        courseRepository.deleteAll();
    }

    public void sendIdToLesson(Long courseID){
        kafkaService.sendCourseIdToLesson(courseID);
    }
}
