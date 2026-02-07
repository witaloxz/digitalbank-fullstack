package com.witalo.digitalbank.service;

import com.witalo.digitalbank.domain.entity.User;
import com.witalo.digitalbank.dto.user.CreateUserRequestDTO;
import com.witalo.digitalbank.dto.user.UserResponseDTO;
import com.witalo.digitalbank.exception.user.CpfAlreadyExistsException;
import com.witalo.digitalbank.exception.user.EmailAlreadyExistsException;
import com.witalo.digitalbank.mapper.UserMapper;
import com.witalo.digitalbank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(CreateUserRequestDTO dto) {

        // 1️⃣ regras de negócio
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException(dto.email());
        }

        if (userRepository.existsByCpf(dto.cpf())) {
            throw new CpfAlreadyExistsException(dto.cpf());
        }

        // 2️⃣ domínio
        User user = UserMapper.toEntity(dto);

        // 3️⃣ persistência
        User savedUser = userRepository.save(user);

        // 4️⃣ resposta
        return UserMapper.toResponseDTO(savedUser);
    }
}
