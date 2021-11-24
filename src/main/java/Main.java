import data.DataStorageManager;
import data.IDataManager;
import domain.Actuator;
import domain.Building;
import domain.BuildingManagementSystem;
import domain.Sensor;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		BuildingManagementSystem system = new BuildingManagementSystem();
		system.addBuilding("Magnus' Højhus");

		Building building = system.getBuildings().get(0);
		building.addVentActuator("Vent");
		building.addVentActuator("Vent");
		building.addVentActuator("Vent");
		building.addVentActuator("Vent");
		building.addCo2Sensor("CO2");
		building.addTemperatureSensor("TEMP");

		IDataManager dsm = new DataStorageManager();
		building.getActuators().get(0).setValue(2.0);
		building.getSensors().get(0).getValue();
	}
}
