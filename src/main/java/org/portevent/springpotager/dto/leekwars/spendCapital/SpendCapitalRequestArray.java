package org.portevent.springpotager.dto.leekwars.spendCapital;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpendCapitalRequestArray {
    private Integer life;
    private Integer strength;
    private Integer wisdom;
    private Integer agility;
    private Integer resistance;
    private Integer frequency;
    private Integer science;
    private Integer magic;
    private Integer cores;
    private Integer ram;
    private Integer tp;
    private Integer mp;

    @Override
    public String toString() {
        return "{" +
                "\"life\":" + life +
                ", \"strength\":" + strength +
                ", \"wisdom\":" + wisdom +
                ", \"agility\":" + agility +
                ", \"resistance\":" + resistance +
                ", \"frequency\":" + frequency +
                ", \"science\":" + science +
                ", \"magic\":" + magic +
                ", \"cores\":" + cores +
                ", \"ram\":" + ram +
                ", \"tp\":" + tp +
                ", \"mp\":" + mp +
                '}';
    }
}
