package hangtum.store.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hangtum.store.cart.model.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    public List<Lesson> findAll();

    public Optional<Lesson> findById(Long id);

    public boolean existsById(Long id);

    public List<Lesson> findByCourseID(String courseID);

}
