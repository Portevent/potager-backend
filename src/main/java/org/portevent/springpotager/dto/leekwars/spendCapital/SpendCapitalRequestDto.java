package org.portevent.springpotager.dto.leekwars.spendCapital;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpendCapitalRequestDto {
    private Long leek_id;
    private String characteristics;

}
