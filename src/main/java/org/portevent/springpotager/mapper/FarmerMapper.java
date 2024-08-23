package org.portevent.springpotager.mapper;

import org.mapstruct.*;
import org.portevent.springpotager.dto.farmer.FarmerDto;
import org.portevent.springpotager.models.Farmer;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {LeekwarsLeekMapper.class})
public interface FarmerMapper {

    Farmer toEntity(FarmerDto dto);

    @Mapping(target = "ratio", expression = "java(entity.getVictories()/((entity.getDefeats()>0)?entity.getDefeats():1f))")
    @Mapping(target = "leek_count", expression = "java(entity.getLeeks().toArray().length)")
    @Mapping(target = "total_level", expression = "java((int) entity.getLeeks().stream().mapToDouble(leek -> leek.getLevel()).sum())")
    FarmerDto toDTO(Farmer entity);

    List<Farmer> toEntities(List<FarmerDto> dtos);

    List<FarmerDto> toDTOs(List<Farmer> entities);
}
