package com.ejemplo.forohub.config;

import com.ejemplo.forohub.model.Usuario;
import com.ejemplo.forohub.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner init(UsuarioRepository repo) {
        return args -> {
            if (repo.findByEmail("user@foro.com").isEmpty()) {
                repo.save(Usuario.builder()
                        .email("user@foro.com")
                        .password(passwordEncoder.encode("password"))
                        .build());
            }
        };
    }
}
