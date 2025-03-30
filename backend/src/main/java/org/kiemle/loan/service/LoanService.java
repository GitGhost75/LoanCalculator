package org.kiemle.loan.service;

import org.kiemle.loan.controller.model.LoanDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LoanService {
	LoanDto create(BigDecimal amount,  BigDecimal interestRate, Integer maturityInMonth);
	List<LoanDto> getAllLoans();
	LoanDto calculate(UUID id);
}
