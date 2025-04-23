package es.grupo12.dto;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import es.grupo12.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    BasicUserDTO map(User user);

    List<UserDTO> toDTOs(Collection<User> users);

    User toDomain(UserDTO userDTO);

}
