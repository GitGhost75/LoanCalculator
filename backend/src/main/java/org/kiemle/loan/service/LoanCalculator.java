package org.kiemle.loan.service;

import lombok.extern.slf4j.Slf4j;
import org.kiemle.loan.model.Loan;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Slf4j
public class LoanCalculator {

	private static final BigDecimal HUNDRED = new BigDecimal("100");
	private static final BigDecimal TWELVE = new BigDecimal("12");

	public BigDecimal calculateInterestRate(final Loan loan) {

		log.info("Calculate rate for loan '{}'", loan.getId());

		BigDecimal monthlyInterestRate =
				loan.getInterestRate().divide(HUNDRED, 10, RoundingMode.HALF_UP)
				    .divide(TWELVE, 10, RoundingMode.HALF_UP);

		BigDecimal pow = BigDecimal.ONE.add(monthlyInterestRate).pow(loan.getMaturityInMonth());

		BigDecimal rate = loan.getAmount().multiply(monthlyInterestRate).multiply(pow)
		           .divide(pow.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

		log.info("Calculated rate for loan '{}' is {}", loan.getId(), rate);

		return rate;
	}
}
