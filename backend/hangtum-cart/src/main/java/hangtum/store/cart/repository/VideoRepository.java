package hangtum.store.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hangtum.store.cart.model.Video;

public interface VideoRepository extends CrudRepository<Video, Long> {
    public List<Video> findAll();

    public Optional<Video> findById(Long id);

    public boolean existsById(Long id);

    public List<Video> findByLessonID(String lessonID);
}
