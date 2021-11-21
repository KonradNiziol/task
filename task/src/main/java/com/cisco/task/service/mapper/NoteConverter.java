package com.cisco.task.service.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cisco.task.domain.note.Note;
import com.cisco.task.service.dto.NoteDto;

@Component
public class NoteConverter {

    public NoteDto convert(final Note note) {
        return NoteDto
                .builder()
                .noteId(note.getNoteId())
                .caseId(note.getCaseId())
                .details(note.getDetails())
                .build();
    }

    public List<NoteDto> convert(final Set<Note> notes) {
        return notes.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
