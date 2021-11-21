package com.cisco.task.service.dto;

import java.util.List;

import com.cisco.task.domain.cases.Case;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public final class CaseDto {

    private Integer caseId;
    private String title;
    private String description;
    private Integer severity;
    private Case.Status status;
    private UserDto user;
    private List<NoteDto> notes;




}
