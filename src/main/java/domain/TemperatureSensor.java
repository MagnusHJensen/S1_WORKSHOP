package domain;

import java.util.UUID;

public class TemperatureSensor extends Sensor {
	public TemperatureSensor(String name) {
		this(name, UUID.randomUUID());
	}

	public TemperatureSensor(String name, UUID id) {
		super(name, id);
	}

	@Override
	public double getValue() {
		// Black magic for the third time :O
		return super.getValue();
	}

	@Override
	public String toString() {
		return "domain.TemperatureSensor{name = " + getName() + " value = " + getValue() + "}";
	}
}
