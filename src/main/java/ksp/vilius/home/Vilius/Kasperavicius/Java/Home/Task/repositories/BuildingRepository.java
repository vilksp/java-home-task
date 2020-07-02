package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.repositories;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
}
