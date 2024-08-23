package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.dto.leek.LeekDto;
import org.portevent.springpotager.dto.leekwars.LeekwarsLeekDto;
import org.portevent.springpotager.models.Leek;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LeekwarsLeekMapper {

    @Mapping(target = "ai", ignore = true)
    Leek toEntity(LeekwarsLeekDto dto);
    @Mapping(target = "ai", ignore = true)
    LeekwarsLeekDto toDTO(Leek entity);

    List<Leek> toEntities(List<LeekwarsLeekDto> dtos);
    List<LeekwarsLeekDto> toDTOs(List<Leek> entities);

    @Named("fromPublicMap")
    default List<Leek> fromPublicMap(Map<Long, LeekwarsLeekDto> dtos){
        return toEntities(dtos.values().stream().toList());
    }

    @Named("toPublicMap")
    default Map<Long, LeekwarsLeekDto> toPublicMap(List<Leek> entities){
        return toDTOs(entities).stream().collect(Collectors.toMap(LeekwarsLeekDto::getId, Function.identity()));
    }
}
