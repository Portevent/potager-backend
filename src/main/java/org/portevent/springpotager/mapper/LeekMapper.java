package org.portevent.springpotager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.portevent.springpotager.dto.leek.LeekDto;
import org.portevent.springpotager.dto.leek.PublicLeekDto;
import org.portevent.springpotager.models.Leek;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LeekMapper {

    @Mapping(target = "ai", ignore = true)
    Leek toEntity(LeekDto dto);
    @Mapping(target = "ai", ignore = true)
    Leek fromPublic(PublicLeekDto dto);
    @Mapping(target = "ai", ignore = true)
    LeekDto toDTO(Leek entity);

    List<Leek> toEntities(List<LeekDto> dtos);
    List<LeekDto> toDTOs(List<Leek> entities);

    List<Leek> fromPublics(List<PublicLeekDto> dtos);
    List<PublicLeekDto> toPublics(List<Leek> entities);

    @Named("fromPublicsMap")
    default List<Leek> fromPublicsMap(Map<Long, PublicLeekDto> dtos){
        return fromPublics(dtos.values().stream().toList());
    }

    @Named("toPublicsMaps")
    default Map<Long, PublicLeekDto> toPublicsMaps(List<Leek> entities){
        return toPublics(entities).stream().collect(Collectors.toMap(PublicLeekDto::getId, Function.identity()));
    }
}
