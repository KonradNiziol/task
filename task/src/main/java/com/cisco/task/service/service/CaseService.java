package com.cisco.task.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.task.domain.cases.Case;
import com.cisco.task.domain.cases.CaseRepository;
import com.cisco.task.service.dto.CaseDto;
import com.cisco.task.service.mapper.CaseConverter;

@Service
@Transactional
public class CaseService {

    private final CaseRepository caseRepository;
    private final CaseConverter caseConverter;

    public CaseService(CaseRepository caseRepository, CaseConverter caseConverter) {
        this.caseRepository = caseRepository;
        this.caseConverter = caseConverter;
    }

    public Optional<CaseDto> findById(final Integer caseId) {
        return caseRepository.findByCaseId(caseId)
                .map(aCase -> caseConverter.convert(aCase));
    }

    public List<CaseDto> findAllBy(final Case.Status status) {
        return caseConverter.convert(caseRepository.findAllByStatus(status));
    }

    public List<CaseDto> findAllByUserId(final Integer userId) {
        return caseConverter.convert(caseRepository.findAllByUser_UserId(userId));
    }

    public List<CaseDto> findAllByUserIdAndStatus(final Integer userId, final Case.Status status) {
        return caseConverter.convert(caseRepository.findAllByUser_UserIdAndStatus(userId, status));
    }
}
