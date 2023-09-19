package hangtum.store.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hangtum.store.cart.model.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
    public List<Note> findAll();

    public Optional<Note> findById(Long id);

    public boolean existsById(Long id);

    public List<Note> findByLessonID(String lessonID);
}
