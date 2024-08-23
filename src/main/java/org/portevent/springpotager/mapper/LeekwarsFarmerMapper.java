package org.portevent.springpotager.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.portevent.springpotager.dto.leekwars.LeekwarsLeekDto;
import org.portevent.springpotager.dto.leekwars.LeekwarsFarmerDto;
import org.portevent.springpotager.models.Farmer;
import org.portevent.springpotager.models.Leek;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {LeekwarsLeekMapper.class})
public interface LeekwarsFarmerMapper {


    @Mapping(target = "leeks", expression = "java(toLeeks(dto))")
    Farmer toEntity(LeekwarsFarmerDto dto);

    @Mapping(target = "leeks", expression = "java(toMap(entity))")
    LeekwarsFarmerDto toDTO(Farmer entity);

    List<Farmer> toEntities(List<LeekwarsFarmerDto> dtos);

    List<LeekwarsFarmerDto> toDTOs(List<Farmer> entities);

    default Map<Long, LeekwarsLeekDto> toMap(Farmer entity) {
        return Mappers.getMapper(LeekwarsLeekMapper.class).toPublicMap(entity.getLeeks());
    }

    default List<Leek> toLeeks(LeekwarsFarmerDto dto) {
        return Mappers.getMapper(LeekwarsLeekMapper.class).fromPublicMap(dto.getLeeks());
    }

    @AfterMapping
    default void mapLeekToFarmer(LeekwarsFarmerDto dto, @MappingTarget Farmer entity) {
        entity.getLeeks().stream().forEach(leek -> leek.setFarmer(entity));
    }
}
