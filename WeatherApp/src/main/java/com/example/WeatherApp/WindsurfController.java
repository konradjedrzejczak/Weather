package com.example.WeatherApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WindsurfController {

    private final WindsurfService windsurfService;

    public WindsurfController(WindsurfService windsurfService) {
        this.windsurfService = windsurfService;
    }

    @GetMapping("/best-spot")
    public ResponseEntity<WindsurfSpot> getBestSpot(@RequestParam("date") String date) {
        WindsurfSpot bestSpot = windsurfService.findBestSpot(date);

        if (bestSpot != null) {
            return ResponseEntity.ok(bestSpot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
