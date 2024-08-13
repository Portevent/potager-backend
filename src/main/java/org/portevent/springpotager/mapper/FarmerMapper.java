package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.dto.FarmerDTO;
import org.portevent.springpotager.models.Farmer;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface FarmerMapper {
    Farmer toEntity(FarmerDTO dto);
    FarmerDTO toDTO(Farmer entity);

    List<Farmer> toEntities(List<FarmerDTO> dtos);
    List<FarmerDTO> toDTOs(List<Farmer> entities);
}
