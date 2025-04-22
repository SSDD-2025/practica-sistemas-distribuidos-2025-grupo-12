package es.grupo12.dto;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import es.grupo12.model.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO toDTO(Message message);

    List<MessageDTO> toDTOs(Collection<Message> message);
    Message toDomain(MessageDTO messageDTO);
}
