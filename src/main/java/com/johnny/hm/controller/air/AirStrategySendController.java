package com.johnny.hm.controller.air;

import com.johnny.hm.bean.Air;
import com.johnny.hm.service.air.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/air/send")
public class AirStrategySendController {
    @Autowired
    AirService airService;
    @GetMapping("/")
    public List<Air> getAirWithStrategy(){
        return airService.getAirWithStrategy();
    }
}
