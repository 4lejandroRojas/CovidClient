package com.health.covid.controllers;

import com.health.covid.exception.ResourceNotFoundException;
import com.health.covid.models.api.DataElement;
import com.health.covid.models.api.ResponseApi;
import com.health.covid.service.IService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
@RequiredArgsConstructor
public class CovidController {

    private final IService service;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping(path = "/daily")
    public ResponseApi getAllData(){
        log.info("Spring profile: {}", profile);
        return service.getDaily();
    }

    @GetMapping(path = "/daily/{date}")
    public DataElement getDataById(@PathVariable String date){

        return service.getDaily().getData().stream().filter(element -> element.getDate().equals(date)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Element not found"));
    }
}
