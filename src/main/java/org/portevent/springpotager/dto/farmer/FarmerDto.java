package org.portevent.springpotager.dto.farmer;

import lombok.Data;

@Data
public class FarmerDto extends PublicFarmerDto {
    protected Boolean pass;

    protected Integer habs;

    protected Integer crystals;

    protected Boolean tournament_registered;

    protected Integer tournament_current;

    protected String candidacy;
}
