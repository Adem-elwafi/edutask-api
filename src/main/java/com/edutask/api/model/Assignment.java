package com.edutask.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du cours est obligatoire")
    private String courseName;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @NotNull(message = "La date d'échéance est obligatoire")
    @Future(message = "La date d'échéance doit être dans le futur")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private boolean isCompleted = false;
}