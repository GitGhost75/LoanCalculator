package org.kiemle.loan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column
	private BigDecimal amount;

	@Column BigDecimal interestRate;

	@Column Integer maturityInMonth;

	@Column BigDecimal rate;
}
