package com.edutask.api.service;

import com.edutask.api.model.Assignment;
import com.edutask.api.record.AssignmentRequest;
import com.edutask.api.record.AssignmentResponse;
import com.edutask.api.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository repository;

    // Méthode pour créer un devoir
    public AssignmentResponse create(AssignmentRequest request) {
        // Mapping Manuel : Request -> Entity
        Assignment assignment = Assignment.builder()
                .courseName(request.courseName())
                .description(request.description())
                .dueDate(request.dueDate())
                .priority(request.priority())
                .isCompleted(false) // Par défaut à la création
                .build();

        Assignment savedAssignment = repository.save(assignment);

        // Mapping Manuel : Entity -> Response
        return mapToResponse(savedAssignment);
    }

    // Helper method pour transformer une entité en réponse
    private AssignmentResponse mapToResponse(Assignment assignment) {
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getCourseName(),
                assignment.getDescription(),
                assignment.getDueDate(),
                assignment.getPriority(),
                assignment.isCompleted()
        );
    }
    // À ajouter dans AssignmentService.java
    public List<AssignmentResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    // Ajouter cette méthode dans AssignmentService
    public List<AssignmentResponse> searchByCourse(String courseName) {
        return repository.findByCourseNameContainingIgnoreCase(courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}