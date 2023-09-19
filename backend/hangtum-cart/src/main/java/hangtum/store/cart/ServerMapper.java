package hangtum.store.cart;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import hangtum.store.cart.model.Lesson;
import hangtum.store.cart.model.LessonDTO;
import hangtum.store.cart.model.Note;
import hangtum.store.cart.model.NoteDTO;
import hangtum.store.cart.model.Video;
import hangtum.store.cart.model.VideoDTO;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateLessonFromDto(LessonDTO dto, @MappingTarget Lesson entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateNoteFromDto(NoteDTO dto, @MappingTarget Note entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateVideoFromDto(VideoDTO dto, @MappingTarget Video entity);
}
