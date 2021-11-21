package com.cisco.task.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cisco.task.domain.cases.Case;
import com.cisco.task.service.dto.CaseDto;

@Component
public class CaseConverter {

    private final UserConverter userConverter;
    private final NoteConverter noteConverter;

    public CaseConverter(UserConverter userConverter, NoteConverter noteConverter) {
        this.userConverter = userConverter;
        this.noteConverter = noteConverter;
    }

    public CaseDto convert(final Case c){
        return CaseDto
                .builder()
                .caseId(c.getCaseId())
                .description(c.getDescription())
                .notes(noteConverter.convert(c.getNotes()))
                .severity(c.getSeverity())
                .status(c.getStatus())
                .title(c.getTitle())
                .user(userConverter.convertFrom(c.getUser()))
                .build();
    }

    public List<CaseDto> convert(final List<Case> cases) {
        return cases.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
