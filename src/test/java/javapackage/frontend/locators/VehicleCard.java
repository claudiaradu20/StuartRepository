package javapackage.frontend.locators;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class VehicleCard {

    public static By WALKER_VEHICLE = By.id("transport-walk");
    public static By BIKE_VEHICLE = By.id("transport-bike");
    public static By CAR_VEHICLE = By.id("transport-car");
    public static By MOTORBIKE_VEHICLE = By.id("transport-motorbike");
    public static By CARGOBIKE_VEHICLE = By.id("transport-cargobike");
    public static By TRUCK_VEHICLE = By.id("transport-truck");

    public static List<By> LISTOFVEHICLES;

    static {
        LISTOFVEHICLES = new ArrayList<>();
        LISTOFVEHICLES.add(WALKER_VEHICLE);
        LISTOFVEHICLES.add(BIKE_VEHICLE);
        LISTOFVEHICLES.add(CAR_VEHICLE);
        LISTOFVEHICLES.add(MOTORBIKE_VEHICLE);
        LISTOFVEHICLES.add(CARGOBIKE_VEHICLE);
        LISTOFVEHICLES.add(TRUCK_VEHICLE);
    }



}
