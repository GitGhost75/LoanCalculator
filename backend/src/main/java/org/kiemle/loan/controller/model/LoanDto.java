package org.kiemle.loan.controller.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class LoanDto {
	private UUID id;
	@NotNull
	@Min(1)
	private final BigDecimal amount;
	@NotNull
	@Min(0)
	private final BigDecimal interestRate;
	@NotNull
	@Min(1)
	private final Integer maturityInMonth;
	private BigDecimal rate;


}
