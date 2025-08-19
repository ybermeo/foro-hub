package com.ejemplo.forohub.service;

import com.ejemplo.forohub.dto.TopicoRequest;
import com.ejemplo.forohub.dto.TopicoResponse;
import com.ejemplo.forohub.model.Topico;
import com.ejemplo.forohub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public List<TopicoResponse> listar() {
        return topicoRepository.findAll()
                .stream()
                .map(t -> new TopicoResponse(t.getId(), t.getUsuarioId(), t.getTitulo(), t.getMensaje(), t.getCurso()))
                .toList();
    }

    public TopicoResponse crear(TopicoRequest r) {
        Topico t = Topico.builder()
                .usuarioId(r.usuarioId())
                .titulo(r.titulo())
                .mensaje(r.mensaje())
                .curso(r.curso())
                .build();
        Topico saved = topicoRepository.save(t);
        return new TopicoResponse(saved.getId(), saved.getUsuarioId(), saved.getTitulo(), saved.getMensaje(), saved.getCurso());
    }

    public void eliminar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Topico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
