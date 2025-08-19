package com.ejemplo.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRequest(
        @NotNull Long usuarioId,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        String curso
) {}
