package domain;

import java.util.UUID;

public class Sensor extends Unit {

	public Sensor(String name) {
		this(name, UUID.randomUUID());
	}

	public Sensor(String name, UUID id) {
		super(name, id);
	}

	public double getValue() {
		double value = Math.random();
		BuildingManagementSystem.DATA_MANAGER.saveSensorValue(this);
		return value;

	}
}
