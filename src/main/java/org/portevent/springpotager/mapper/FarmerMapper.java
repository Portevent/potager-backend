package org.portevent.springpotager.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.portevent.springpotager.dto.farmer.FarmerDto;
import org.portevent.springpotager.dto.farmer.PublicFarmerDto;
import org.portevent.springpotager.dto.leek.LeekDto;
import org.portevent.springpotager.dto.leek.PublicLeekDto;
import org.portevent.springpotager.models.Farmer;
import org.portevent.springpotager.models.Leek;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {LeekMapper.class})
public interface FarmerMapper {

    FarmerMapper INSTANCE = Mappers.getMapper(FarmerMapper.class);

    @Mapping(target = "leeks", expression = "java(toLeeks(dto.getLeeks()))")
    Farmer toEntity(FarmerDto dto);

    @Mapping(target = "leeks", expression = "java(toPublicMaps(entity.getLeeks()))")
    FarmerDto toDTO(Farmer entity);

    List<Farmer> toEntities(List<FarmerDto> dtos);

    List<FarmerDto> toDTOs(List<Farmer> entities);

    @Mapping(target = "leeks", expression = "java(toLeeks(dto.getLeeks()))")
    Farmer fromPublic(PublicFarmerDto dto);

    default List<Leek> toLeeks(Map<Long, PublicLeekDto> dtos) {
        return Mappers.getMapper(LeekMapper.class).fromPublicsMap(dtos);
    }

    default Map<Long, PublicLeekDto> toPublicMaps(List<Leek> entities) {
        return Mappers.getMapper(LeekMapper.class).toPublicsMaps(entities);
    }
}
