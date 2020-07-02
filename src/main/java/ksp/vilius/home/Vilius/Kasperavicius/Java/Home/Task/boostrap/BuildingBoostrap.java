package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.boostrap;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Address;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Owner;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.PropertyType;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.repositories.BuildingRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingBoostrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BuildingRepository buildingRepository;

    public BuildingBoostrap(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        buildingRepository.saveAll(getAllBuildings());
    }

    public List<Building> getAllBuildings() {
        List<Building> buildingList = new ArrayList<>();

        Building house = new Building();
        house.setId(1l);
        house.setSize(96);
        house.setPropertyType(PropertyType.HOUSE);
        house.setMarketVal(15000);
        house.setOwner(new Owner("Aang", "Air", house));
        house.setAddress(new Address("Vilnius", "sodai", 15, house));

        buildingList.add(house);


        Building industrial = new Building();
        industrial.setId(2l);
        industrial.setSize(150);
        industrial.setPropertyType(PropertyType.INDUSTRIAL);
        industrial.setMarketVal(44000);
        industrial.setOwner(new Owner("Smith", "Fire", industrial));
        industrial.setAddress(new Address("Kaunas", "silainiu", 10, industrial));

        buildingList.add(industrial);

        return buildingList;
    }

}
