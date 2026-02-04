package com.dyform.dynamic_forms.service.Impl;

import com.dyform.dynamic_forms.dto.LoginDTO;
import com.dyform.dynamic_forms.dto.UserDTO;
import com.dyform.dynamic_forms.entity.User;
import com.dyform.dynamic_forms.entity.UserRole;
import com.dyform.dynamic_forms.repository.UserRepository;
import com.dyform.dynamic_forms.security.JwtService;
import com.dyform.dynamic_forms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtService jwtService;


    @Override
    public void register(UserDTO userDTO){
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .role(UserRole.ADMIN)
                .passwordHash(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .build();

        userRepository.save(user);




    }

    @Override
    public String login(LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }


        return jwtService.generateToken(user);
    }

}
