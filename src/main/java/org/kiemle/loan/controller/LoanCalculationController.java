package org.kiemle.loan.controller;

import org.kiemle.loan.controller.model.LoanDto;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LoanCalculationController {

	ResponseEntity<LoanDto> create(
			BigDecimal amount,
			BigDecimal interestRate,
			Integer maturityInMonth);

	ResponseEntity<List<LoanDto>> getAllLoans();

	ResponseEntity<LoanDto> calculate(UUID id);
}
