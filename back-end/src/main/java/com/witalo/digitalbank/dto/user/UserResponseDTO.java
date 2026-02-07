package com.witalo.digitalbank.dto.user;

import com.witalo.digitalbank.domain.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private UserStatus status;
    private LocalDateTime createdAt;
}
