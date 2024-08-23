package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.dto.leek.LeekDto;
import org.portevent.springpotager.models.Leek;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LeekMapper {

    @Mapping(target = "ai", ignore = true)
    Leek toEntity(LeekDto dto);
    LeekDto toDTO(Leek entity);

    List<Leek> toEntities(List<LeekDto> dtos);
    List<LeekDto> toDTOs(List<Leek> entities);
}
