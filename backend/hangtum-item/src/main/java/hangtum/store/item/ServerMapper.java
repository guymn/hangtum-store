package hangtum.store.item;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import hangtum.store.item.model.Category;
import hangtum.store.item.model.CategoryDTO;
import hangtum.store.item.model.Course;
import hangtum.store.item.model.CourseDTO;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateCourseFromDto(CourseDTO dto, @MappingTarget Course entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateCategoryFromDto(CategoryDTO dto, @MappingTarget Category entity);
}
