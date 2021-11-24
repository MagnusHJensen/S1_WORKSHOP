package domain;

import java.util.UUID;

public class Actuator extends Unit {
	private double value;

	public Actuator(String name) {
		this(name, UUID.randomUUID());
	}

	public Actuator(String name, UUID id) {
		super(name, id);
	}

	public void setValue(double value) {
		this.value = value;
		BuildingManagementSystem.DATA_MANAGER.saveActuatorValue(this);
	}

	public double getValue() {
		return this.value;
	}
}
