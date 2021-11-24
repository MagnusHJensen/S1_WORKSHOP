package data;

import domain.Actuator;
import domain.Sensor;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface IDataManager {

	boolean saveActuatorValue(Actuator actuator);
	boolean saveSensorValue(Sensor sensor);

	HashMap<UUID, ArrayList<String>> loadActuatorValues();
	HashMap<UUID, ArrayList<String>> loadSensorValues();
}
