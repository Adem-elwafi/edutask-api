package com.edutask.api.record;

import com.edutask.api.model.Priority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AssignmentRequest(
        @NotBlank(message = "Course name is required")
        String courseName,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Due date is required")
        @Future(message = "Due date must be in the future")
        LocalDate dueDate,

        @NotNull(message = "Priority is required")
        Priority priority
) {}