package com.cisco.task.domain.cases;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cisco.task.domain.generic.BaseEntity;
import com.cisco.task.domain.note.Note;
import com.cisco.task.domain.user.User;

@Entity
@Table(name = "cases")
public class Case extends BaseEntity {

    private Integer caseId;
    private String title;
    private String description;
    private Integer severity;
    private Status status;
    @ManyToOne()
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @OneToMany(mappedBy = "caseId")
    private Set<Note> notes;

    public Case() {
    }

    public Case(Integer caseId, String title, String description, Integer severity, Status status, User user,
            Set<Note> notes) {
        this.caseId = caseId;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.user = user;
        this.notes = notes;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getSeverity() {
        return severity;
    }

    public Status getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public enum Status {
        OPEN,
        CLOSED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Case aCase = (Case) o;
        return Objects.equals(caseId, aCase.caseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId);
    }
}
