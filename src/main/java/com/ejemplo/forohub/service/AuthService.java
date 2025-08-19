package com.ejemplo.forohub.service;

import com.ejemplo.forohub.dto.AuthRequest;
import com.ejemplo.forohub.dto.AuthResponse;
import com.ejemplo.forohub.model.Usuario;
import com.ejemplo.forohub.repository.UsuarioRepository;
import com.ejemplo.forohub.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse authenticate(AuthRequest request) {
        Usuario u = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
        if (!passwordEncoder.matches(request.password(), u.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }
        String token = jwtUtil.generate(u.getEmail());
        return new AuthResponse("Bearer", token);
    }
}
