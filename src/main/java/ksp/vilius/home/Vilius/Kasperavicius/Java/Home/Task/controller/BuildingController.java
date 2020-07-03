package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.controller;


import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.BuildingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buildings")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {

        return new ResponseEntity<List<Building>>(buildingService.getAllBuildings(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {


        return new ResponseEntity<Building>(buildingService.getBuildingById(id), HttpStatus.OK);
    }


    @PostMapping("{id}")
    public ResponseEntity<Building> createBuilding(@PathVariable Long id, @RequestBody Building building) {

        buildingService.createBuilding(building);
        return new ResponseEntity<>(building, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {

        buildingService.deleteBuildingById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Building> updateBuilding(Building updBuilding) {

        buildingService.updateBuilding(updBuilding);

        return new ResponseEntity<Building>(updBuilding, HttpStatus.OK);
    }

}
