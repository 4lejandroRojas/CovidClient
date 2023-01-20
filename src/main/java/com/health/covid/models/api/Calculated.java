package com.health.covid.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calculated {
    private Double population_percent;
    private Long change_from_prior_day;
    private Double seven_day_change_percent;
    private Long seven_day_average; //Just in outcomes.hospitalized.currently: calculated, in_icu, on_ventilor
}
