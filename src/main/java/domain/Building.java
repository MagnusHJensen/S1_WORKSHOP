package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building extends Unit {
	private List<Sensor> sensors;
	private List<Actuator> actuators;

	public Building(String name) {
		this(name, UUID.randomUUID());
	}

	public Building(String name, UUID id) {
		super(name, id);
		this.sensors = new ArrayList<>();
		this.actuators = new ArrayList<>();
	}


	public List<Sensor> getSensors() {
		return List.copyOf(this.sensors);
	}

	public List<Actuator> getActuators() {
		return List.copyOf(this.actuators);
	}

	public UUID addTemperatureSensor(String name) {
		TemperatureSensor temperatureSensor = new TemperatureSensor(name);
		this.sensors.add(temperatureSensor);
		return temperatureSensor.getID();
	}

	public UUID addCo2Sensor(String name) {
		Co2Sensor co2Sensor = new Co2Sensor(name);
		this.sensors.add(co2Sensor);
		return co2Sensor.getID();
	}

	public void removeSensor(UUID id) {
		int idxToRemove = -1;
		for (int i = 0; i < this.sensors.size(); i++) {
			if (this.sensors.get(i).getID().equals(id)) {
				idxToRemove = i;
				break;
			}
		}
		if (idxToRemove == -1) return; // Early exit.
		this.sensors.remove(idxToRemove);
	}

	public UUID addVentActuator(String name) {
		VentilationActuator ventilationActuator = new VentilationActuator(name);
		this.actuators.add(ventilationActuator);
		return ventilationActuator.getID();
	}

	public void removeActuator(UUID id) {
		int idxToRemove = -1;
		for (int i = 0; i < this.actuators.size(); i++) {
			if (this.actuators.get(i).getID().equals(id)) {
				idxToRemove = i;
				break;
			}
		}
		if (idxToRemove == -1) return; //Early exit.
		this.actuators.remove(idxToRemove);
	}
}
