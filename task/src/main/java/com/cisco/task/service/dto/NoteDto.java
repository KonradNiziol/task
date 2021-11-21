package com.cisco.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class NoteDto {

    private Integer noteId;
    private Integer caseId;
    private String details;

}
