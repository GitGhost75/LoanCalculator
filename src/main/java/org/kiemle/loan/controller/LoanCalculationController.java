package org.kiemle.loan.controller;

import org.kiemle.loan.controller.model.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LoanCalculationController {

	ResponseEntity<LoanDto> create(@RequestParam BigDecimal amount, @RequestParam BigDecimal interestRate, Integer maturityInMonth);

	ResponseEntity<List<LoanDto>> getAllLoans();

	ResponseEntity<LoanDto> calculate(@PathVariable UUID id);
}
