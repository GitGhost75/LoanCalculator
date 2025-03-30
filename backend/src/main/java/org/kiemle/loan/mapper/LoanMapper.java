package org.kiemle.loan.mapper;

import org.kiemle.loan.controller.model.LoanDto;
import org.kiemle.loan.model.Loan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {

	Loan toLoanEntity(LoanDto dto);

	List<LoanDto> toLoanDtoList(List<Loan> entities);

	LoanDto toLoanDto(Loan loan);
}
