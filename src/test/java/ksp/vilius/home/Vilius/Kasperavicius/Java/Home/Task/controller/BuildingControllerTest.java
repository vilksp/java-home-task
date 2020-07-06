package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.controller;

import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Address;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Building;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.Owner;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model.PropertyType;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.repositories.BuildingRepository;
import ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.service.BuildingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BuildingControllerTest {

    @Mock
    BuildingService buildingService;


    MockMvc mockMvc;

    @InjectMocks
    BuildingController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);


    }

    @Test
    void getAllBuildings() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/buildings"))
                .andExpect(status().isOk());

    }

    @Test
    void getBuildingById() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/buildings/{id}", 1L))
                .andExpect(status().isOk());


    }

    @Test
    void createBuilding() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        Building testBuilding = new Building();
        Address testAddress = new Address("Test", "street", 4, testBuilding);

        Owner testOwner = new Owner("John", "smith", testBuilding);
        testBuilding.setId(1l);
        testBuilding.setAddress(testAddress);
        testBuilding.setOwner(testOwner);
        testBuilding.setMarketVal(150000);
        testBuilding.setPropertyType(PropertyType.HOUSE);
        testBuilding.setSize(96);

        buildingService.createBuilding(testBuilding);

        verify(buildingService, times(1)).createBuilding(testBuilding);

    }

    @Test
    void deleteBuilding() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        Building testBuilding = new Building();
        Address testAddress = new Address("Test", "street", 4, testBuilding);

        Owner testOwner = new Owner("John", "smith", testBuilding);
        testBuilding.setId(1l);
        testBuilding.setAddress(testAddress);
        testBuilding.setOwner(testOwner);
        testBuilding.setMarketVal(150000);
        testBuilding.setPropertyType(PropertyType.HOUSE);
        testBuilding.setSize(96);

        buildingService.deleteBuildingById(testBuilding.getId());

        verify(buildingService, times(1)).deleteBuildingById(testBuilding.getId());

    }

    @Test
    void updateBuilding() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        Building testBuilding = new Building();
        Address testAddress = new Address("Test", "street", 4, testBuilding);

        Owner testOwner = new Owner("John", "smith", testBuilding);
        testBuilding.setId(1l);
        testBuilding.setAddress(testAddress);
        testBuilding.setOwner(testOwner);
        testBuilding.setMarketVal(150000);
        testBuilding.setPropertyType(PropertyType.HOUSE);
        testBuilding.setSize(96);

        buildingService.createBuilding(testBuilding);

        Owner Og = new Owner("Jonas", "Ponas", testBuilding);

        testBuilding.setOwner(Og);

        buildingService.updateBuilding(testBuilding);

        assertEquals(Og, testBuilding.getOwner());

    }
}