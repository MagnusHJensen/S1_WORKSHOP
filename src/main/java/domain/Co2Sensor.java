package domain;

import java.util.UUID;

public class Co2Sensor extends Sensor{
	public Co2Sensor(String name) {
		this(name, UUID.randomUUID());
	}

	public Co2Sensor(String name, UUID id) {
		super(name, id);
	}

	@Override
	public double getValue() {
		// Black magic once again
		return super.getValue();
	}

	@Override
	public String toString() {
		return "domain.Co2Sensor{name = " + getName() + " value = " + getValue() + "}";
	}
}
