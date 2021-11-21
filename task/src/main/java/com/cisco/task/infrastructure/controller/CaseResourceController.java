package com.cisco.task.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.task.domain.cases.Case;
import com.cisco.task.service.dto.CaseDto;
import com.cisco.task.service.dto.NoteDto;
import com.cisco.task.service.service.CaseService;

@RestController
public class CaseResourceController {

    private final CaseService caseService;

    public CaseResourceController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/cases/status/{status}")
    ResponseEntity<List<CaseDto>> getCasesWithStatus(@PathVariable Case.Status status) {
        return ResponseEntity.ok(caseService.findAllBy(status));
    }
    @GetMapping("/cases/user/{userId}")
    ResponseEntity<List<CaseDto>> getOpenCases(@PathVariable Integer userId) {
        return ResponseEntity.ok(caseService.findAllByUserId(userId));
    }
    @GetMapping("/cases/user/{userId}/status/{status}")
    ResponseEntity<List<CaseDto>> getOpenCases(@PathVariable Integer userId, @PathVariable
            Case.Status status) {
        // TODO: Query for cases with a userId and status
        return ResponseEntity.ok(caseService.findAllByUserIdAndStatus(userId, status));
    }
    @GetMapping("/case/{caseId}")
    ResponseEntity<CaseDto> getCase(@PathVariable Integer caseId) {
        return caseService.findById(caseId)
                .map(caseDto -> ResponseEntity.ok(caseDto))
                .orElseGet(() -> (ResponseEntity<CaseDto>) ResponseEntity.notFound());
    }
    @PostMapping(value = "/case/create", consumes = "application/json")
    ResponseEntity<CaseDto> createCase(@RequestBody Case toCreate) {
        // TODO: Create a case and any associated records (user, notes)
        return ResponseEntity.internalServerError().build();
    }
    @PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
    ResponseEntity<NoteDto> addNote(@PathVariable Integer caseId, @RequestBody String detail) {
        // TODO: Create a note for the specified case
        return ResponseEntity.internalServerError().build();
    }
}
