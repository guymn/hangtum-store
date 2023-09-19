package hangtum.store.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hangtum.store.item.ServerMapper;
import hangtum.store.item.model.Category;
import hangtum.store.item.model.CategoryDTO;
import hangtum.store.item.repository.CategoryRepository;

@Service
public class CategotyControllerService {
    private final CategoryRepository categoryRepository;
    private final ServerMapper serverMapper;

    @Autowired
    public CategotyControllerService(CategoryRepository categoryRepository, ServerMapper serverMapper) {
        this.categoryRepository = categoryRepository;
        this.serverMapper = serverMapper;
    }

    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Optional<Category> getCategoryById(Long id) {
        Optional<Category> optCategory = categoryRepository.findById(id);
        return optCategory;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void mapperCategory(CategoryDTO categoryDTO, Category category) {
        serverMapper.updateCategoryFromDto(categoryDTO, category);
        saveCategory(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategory() {
        categoryRepository.deleteAll();
    }

}
