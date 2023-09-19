package hangtum.store.item.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hangtum.store.item.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    public List<Category> findAll();

    public Optional<Category> findById(Long id);

    public boolean existsById(Long id);
}
