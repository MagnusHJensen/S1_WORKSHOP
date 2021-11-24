package domain;

import data.DataStorageManager;
import data.IDataManager;

import java.util.*;

public class BuildingManagementSystem implements IBuildingManagementSystem {
	private List<Building> buildings;
	public static final IDataManager DATA_MANAGER = new DataStorageManager();

	public BuildingManagementSystem() {
		this.buildings = new ArrayList<>();
	}

	public List<Building> getBuildings() {
		return List.copyOf(this.buildings);
	}

	public UUID addBuilding(String name) {
		Building building = new Building(name);
		this.buildings.add(building);
		return building.getID();
	}

	public void removeBuilding(UUID id) {
		int idxToRemove = -1;
		for (int i = 0; i < this.buildings.size(); i++) {
			if (this.buildings.get(i).getID().equals(id)) {
				idxToRemove = i;
				break;
			}
		}
		if (idxToRemove == -1) return;
		this.buildings.remove(idxToRemove);
	}

	@Override
	public Map<UUID, String> getBuildingInformation() {
		HashMap<UUID, String> buildings = new HashMap<>();

		for (Building building : this.getBuildings()) {
			buildings.put(building.getID(), building.getName());
		}

		return buildings;
	}

	@Override
	public Map<UUID, String> getSensorInformation(UUID buildingId) {
		HashMap<UUID, String> sensors = new HashMap<>();

		Building chosenBuilding = this.getBuildingById(buildingId);

		for (Sensor sensor : chosenBuilding.getSensors()) {
			sensors.put(sensor.getID(), sensor.getName());
		}

		return sensors;
	}

	@Override
	public Map<UUID, String> getActuatorInformation(UUID buildingId) {
		HashMap<UUID, String> actuators = new HashMap<>();

		Building chosenBuilding = this.getBuildingById(buildingId);

		for (Actuator actuator : chosenBuilding.getActuators()) {
			actuators.put(actuator.getID(), actuator.getName());
		}

		return actuators;
	}

	@Override
	public UUID addTemperatureSensor(UUID buildingId, String name) {
		return this.getBuildingById(buildingId).addTemperatureSensor(name);
	}

	@Override
	public UUID addCo2Sensor(UUID buildingId, String name) {
		return this.getBuildingById(buildingId).addCo2Sensor(name);
	}

	@Override
	public void removeSensor(UUID buildingId, UUID sensorId) {
		this.getBuildingById(buildingId).removeSensor(sensorId);
	}

	@Override
	public UUID addVentilationActuator(UUID buildingId, String name) {
		return this.getBuildingById(buildingId).addVentActuator(name);
	}

	@Override
	public void removeActuator(UUID buildingId, UUID actuatorId) {
		this.getBuildingById(buildingId).removeActuator(actuatorId);
	}

	private Building getBuildingById(UUID buildingId) {
		Building building = null;
		for (Building build : this.getBuildings()) {
			if (build.getID().equals(buildingId)) {
				building = build;
				break;
			}
		}

		return building;
	}
}
