package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.DataJpa;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.repositories.BuildingRepository;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.BuildingService;

import java.util.ArrayList;
import java.util.List;

public class BuildingServiceJpa implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceJpa(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Building> getAllBuildings() {
        List<Building> buildings = new ArrayList<>();
        buildingRepository.findAll().iterator().forEachRemaining(buildings::add);
        return buildings;
    }

    @Override
    public Building createBuilding(Building createBuilding) {
        buildingRepository.save(createBuilding);
        return createBuilding;
    }

    @Override
    public void deleteBuilding(Building deleteBuilding) {
        buildingRepository.delete(deleteBuilding);
    }

    @Override
    public void deleteBuildingById(Long buildingId) {
        buildingRepository.deleteById(buildingId);
    }

    @Override
    public Building updateBuilding(Building updateBuilding) {
        Building updBuilding = new Building();
        updBuilding.setId(updateBuilding.getId());
        updBuilding.setAddress(updateBuilding.getAddress());
        updBuilding.setMarketVal(updateBuilding.getMarketVal());
        updBuilding.setOwner(updateBuilding.getOwner());
        updBuilding.setPropertyType(updateBuilding.getPropertyType());
        updBuilding.setSize(updateBuilding.getSize());

        buildingRepository.save(updBuilding);

        return updBuilding;
    }
}
