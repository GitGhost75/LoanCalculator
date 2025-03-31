package org.kiemle;

import org.kiemle.common.Profiles;
import org.kiemle.configuration.TestConfiguration;
import org.springframework.boot.SpringApplication;

class TestLoanCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.from(LoanCalculatorApplication::main)
		                 .with(TestConfiguration.class)
		                 .withAdditionalProfiles(Profiles.LOCAL)
		                 .run(args);
	}
}