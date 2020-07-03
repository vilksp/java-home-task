package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingService {

    List<Building> getAllBuildings();

    Building getBuildingById(Long id);

    Building createBuilding(Building createBuilding);

    void deleteBuildingById(Long buildingId);

    Building updateBuilding(Building updateBuilding);

}
