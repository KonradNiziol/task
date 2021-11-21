package com.cisco.task.domain.note;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cisco.task.domain.generic.BaseEntity;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity {

    private Integer noteId;
    private Integer caseId;
    private String details;

    public Note() {
    }

    public Note(Integer noteId, Integer caseId, String details) {
        this.noteId = noteId;
        this.caseId = caseId;
        this.details = details;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(noteId, note.noteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId);
    }
}
