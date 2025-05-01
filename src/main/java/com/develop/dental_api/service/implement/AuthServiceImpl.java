package com.develop.dental_api.service.implement;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.develop.dental_api.model.dto.ChangePasswordDTO;
import com.develop.dental_api.model.dto.LoginRequestDTO;
import com.develop.dental_api.model.dto.LoginResponseDTO;
import com.develop.dental_api.model.dto.MessageResponseDTO;
import com.develop.dental_api.model.dto.RegisterUserRequestDTO;
import com.develop.dental_api.model.dto.RegisterUserResponseDTO;
import com.develop.dental_api.model.entity.ClinicalRecord;
import com.develop.dental_api.model.entity.Profile;
import com.develop.dental_api.model.entity.User;
import com.develop.dental_api.model.mapper.UserMapper;
import com.develop.dental_api.repository.ClinicalRecordRepository;
import com.develop.dental_api.repository.ProfileRepository;
import com.develop.dental_api.repository.UserRepository;
import com.develop.dental_api.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final UserMapper userMapper;
    private final ClinicalRecordRepository clinicalRecordRepository;

    @Override
    public RegisterUserResponseDTO register(RegisterUserRequestDTO dto) {
        
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con ese email.");
        }

        
        if (profileRepository.existsByDni(dto.getDni())) {
            throw new IllegalArgumentException("Ya existe un perfil registrado con ese DNI.");
        }

        
        User user = userMapper.toUserEntity(dto);
        user.setRole(dto.getRole());
        user = userRepository.save(user);

        
        Profile profile = userMapper.toProfileEntity(dto, user);
        profileRepository.save(profile);

        
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setUser(user);
        clinicalRecord.setCreatedAt(LocalDateTime.now());
        clinicalRecordRepository.save(clinicalRecord);

        return new RegisterUserResponseDTO("Usuario registrado exitosamente", user.getUserId());
    }
    
    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new LoginResponseDTO("TOKEN_FAKE", userMapper.toUserLoginDTO(user));
    }

    @Override
    public MessageResponseDTO sendRecoveryEmail(String email) {
        // Simulación
        return new MessageResponseDTO("Se envió un correo para recuperar la contraseña");
    }

    @Override
    public MessageResponseDTO changePassword(ChangePasswordDTO dto) {
        // Simulación
        return new MessageResponseDTO("Contraseña actualizada");
    }
}
