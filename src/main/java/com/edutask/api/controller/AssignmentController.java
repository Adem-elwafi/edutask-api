package com.edutask.api.controller;

import com.edutask.api.record.AssignmentRequest;
import com.edutask.api.record.AssignmentResponse;
import com.edutask.api.service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssignmentResponse createAssignment(@RequestBody @Valid AssignmentRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<AssignmentResponse> getAllAssignments() {
        return service.findAll(); // Attention : il faut ajouter cette méthode dans le Service !
    }
}