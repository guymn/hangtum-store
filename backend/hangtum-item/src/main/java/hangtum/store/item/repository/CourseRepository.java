package hangtum.store.item.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hangtum.store.item.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findAll();

    public Optional<Course> findById(Long id);

    public boolean existsById(Long id);

    public List<Course> findByCategoryID(String categoryID);

    public List<Course> findByTeacherID(String teacherID);

}
