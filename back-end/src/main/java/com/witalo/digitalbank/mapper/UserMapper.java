package com.witalo.digitalbank.mapper;

import com.witalo.digitalbank.domain.entity.User;
import com.witalo.digitalbank.domain.enums.UserStatus;
import com.witalo.digitalbank.dto.user.CreateUserRequestDTO;
import com.witalo.digitalbank.dto.user.UserResponseDTO;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(CreateUserRequestDTO dto) {
        return new User(
                dto.name(),
                dto.email(),
                dto.cpf(),
                dto.password()
        );
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getStatus(),
                user.getCreatedAt()
        );
    }
}

