public class Main {
	public static void main(String[] args) {
		BuildingManagementSystem system = new BuildingManagementSystem();

		system.addBuilding("Magnus' Højhus");

		Building building = system.getBuildings().get(0);
		building.addVentActuator("Vent");
		building.addCo2Sensor("CO2");
		building.addTemperatureSensor("TEMP");

		for (Building build : system.getBuildings()) {
			System.out.println(build);
			for (Sensor sensor : build.getSensors()) {
				System.out.println(sensor);
			}
			build.getActuators().get(0).setValue(2.0);
			for (Actuator actuator : build.getActuators()) {
				System.out.println(actuator);
			}
			build.removeActuator(build.getActuators().get(0).getID());
			System.out.println(build.getActuators().size());
		}

	}
}
