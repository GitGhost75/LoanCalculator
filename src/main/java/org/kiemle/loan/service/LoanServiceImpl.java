package org.kiemle.loan.service;

import org.kiemle.loan.controller.model.LoanDto;
import org.kiemle.loan.exception.LoanNotFoundException;
import org.kiemle.loan.mapper.LoanMapper;
import org.kiemle.loan.model.Loan;
import org.kiemle.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoanMapper loanMapper;
	@Autowired
	private LoanCalculator calculator;

	@Override
	public LoanDto create(BigDecimal amount,  BigDecimal interestRate, Integer maturityInMonth){

		LoanDto loanDto = new LoanDto(amount, interestRate, maturityInMonth);
		Loan loan = loanMapper.toLoanEntity(loanDto);

		loan = loanRepository.save(loan);

		return loanMapper.toLoanDto(loan);
	}

	@Override
	public List<LoanDto> getAllLoans() {
		List<Loan> loanList = loanRepository.findAll();

		List<LoanDto> dtoList = loanMapper.toLoanDtoList(loanList);
		return dtoList;
	}

	@Override
	public LoanDto calculate(UUID id) {

		Loan loan = loanRepository.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan with id '" + id + "' not found"));

		BigDecimal interestRate = calculator.calculateInterestRate(loan);
		loan.setRate(interestRate);

		loan = loanRepository.save(loan);

		return loanMapper.toLoanDto(loan);
	}


}
