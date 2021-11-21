package com.cisco.task.domain.cases;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import com.cisco.task.domain.user.User;

public interface CaseRepository extends JpaRepository<Case, Long> {

     Optional<Case> findByCaseId(Integer caseId);

     List<Case> findAllByStatus(Case.Status status);

     List<Case> findAllByUser_UserId(Integer userId);

     List<Case> findAllByUser_UserIdAndStatus(Integer userId, Case.Status status);
}
