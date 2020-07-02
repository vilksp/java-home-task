package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;

import java.util.List;

public interface BuildingService {

    List<Building> getAllBuildings();

    Building createBuilding(Building createBuilding);

    void deleteBuilding(Building deleteBuilding);

    void deleteBuildingById(Long buildingId);

    Building updateBuilding(Building updateBuilding);

}
