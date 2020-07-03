package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.DataJpa;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.repositories.BuildingRepository;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
    public Building getBuildingById(Long id) {
        Optional<Building> buildingById = buildingRepository
                .findById(id);

        return buildingById.orElseThrow(()->new RuntimeException("There's no building with such id!"));
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
