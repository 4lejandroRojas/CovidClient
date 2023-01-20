package com.health.covid.service;

import com.health.covid.clients.CovidFeignClient;
import com.health.covid.models.api.ResponseApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService{

    private final CovidFeignClient covidFeignClient;

    @Override
    public ResponseApi getDaily() {
        return covidFeignClient.getDailyResponse();
    }
}
