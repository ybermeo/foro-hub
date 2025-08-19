package com.ejemplo.forohub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "topicos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String mensaje;

    @Column
    private String curso;
}
