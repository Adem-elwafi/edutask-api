package com.edutask.api.record;

import com.edutask.api.model.Priority;
import java.time.LocalDate;

public record AssignmentResponse(
        Long id,
        String courseName,
        String description,
        LocalDate dueDate,
        Priority priority,
        boolean isCompleted
) {}