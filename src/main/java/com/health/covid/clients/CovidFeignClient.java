package com.health.covid.clients;

import com.health.covid.models.api.ResponseApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "covidFeignClient", url = "https://api.covidtracking.com/v2")
public interface CovidFeignClient {

    @GetMapping("/us/daily.json")
    ResponseApi getDailyResponse();
}
