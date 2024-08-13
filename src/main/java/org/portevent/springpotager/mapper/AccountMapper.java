package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.dto.AccountCreationDTO;
import org.portevent.springpotager.dto.AccountDTO;
import org.portevent.springpotager.models.Account;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AccountMapper {
    Account toCreationEntity(AccountCreationDTO dto);
    Account toEntity(AccountDTO dto);
    AccountDTO toDTO(Account entity);

    List<Account> toEntities(List<AccountDTO> dtos);
    List<AccountDTO> toDTOs(List<Account> entities);
}
