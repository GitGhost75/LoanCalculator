package org.kiemle.loan.controller;

import org.kiemle.loan.controller.model.LoanDto;
import org.kiemle.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class LoanCalculationControllerImpl implements LoanCalculationController {

	@Autowired
	private LoanService loanService;

	@Override
	@PostMapping("/loans/create")
	public ResponseEntity<LoanDto> create(@RequestParam BigDecimal amount,
	                                      @RequestParam BigDecimal interestRate,
	                                      @RequestParam Integer maturityInMonth) {
		LoanDto loanDto = loanService.create(amount, interestRate, maturityInMonth);
		return ResponseEntity.ok(loanDto);
	}

	@Override
	@GetMapping("/loans/get")
	public ResponseEntity<List<LoanDto>> getAllLoans() {
		List<LoanDto> allLoans = loanService.getAllLoans();
		return ResponseEntity.ok(allLoans);
	}

	@Override
	@GetMapping("/loans/calculate/{id}")
	public ResponseEntity<LoanDto> calculate(UUID id) {
		LoanDto loanDto = loanService.calculate(id);
		return ResponseEntity.ok(loanDto);
	}
}
