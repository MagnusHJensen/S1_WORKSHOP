package data;

import domain.Actuator;
import domain.Sensor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.*;

public class DataStorageManager implements IDataManager {

	private final String actuatorPath = "actuators.txt";
	private final String sensorPath = "sensors.txt";


	@Override
	public boolean saveActuatorValue(Actuator actuator) {
		HashMap<UUID, ArrayList<String>> savedValues = loadActuatorValues();
		ArrayList<String> values = savedValues.getOrDefault(actuator.getID(), new ArrayList<>());
		values.add(LocalDateTime.now() + "/" + actuator.getValue());
		savedValues.put(actuator.getID(), values);

		return saveFile(new File(actuatorPath), savedValues);
	}

	@Override
	public boolean saveSensorValue(Sensor sensor) {
		HashMap<UUID, ArrayList<String>> savedValues = loadSensorValues();
		ArrayList<String> values = savedValues.getOrDefault(sensor.getID(), new ArrayList<>());
		values.add(LocalDateTime.now() + "/" + sensor.getValue());
		savedValues.put(sensor.getID(), values);

		return saveFile(new File(sensorPath), savedValues);
	}

	@Override
	public HashMap<UUID, ArrayList<String>> loadActuatorValues() {
		return loadFile(actuatorPath);
	}

	@Override
	public HashMap<UUID, ArrayList<String>> loadSensorValues() {
		return loadFile(sensorPath);
	}

	private HashMap<UUID, ArrayList<String>> loadFile(String path) {
		Scanner scanner = null;
		HashMap<UUID, ArrayList<String>> values = new HashMap<>();
		try  {
			scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();// 1074fa64-ac1b-4676-bae2-900b00d1189e|2021-11-22T10:09:21.843025/2.0;
				String[] keyVal = line.split("\\|"); // Index 0 -> 1074fa64-ac1b-4676-bae2-900b00d1189e - Index 1 ->
				UUID key = UUID.fromString(keyVal[0]);

				ArrayList<String> listValues = new ArrayList<>(Arrays.asList(keyVal[1].split(";")));
				values.put(key, listValues);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return values;
	}

	private boolean saveFile(File test, HashMap<UUID, ArrayList<String>> values) {
		PrintWriter pw = null;
		File file = new File(actuatorPath);

		try {
			pw = new PrintWriter(file);
			for (Map.Entry<UUID, ArrayList<String>> entry : values.entrySet()) {
				pw.print(entry.getKey() + "|");
				for (String value : entry.getValue()) {
					pw.print(value + ";");
				}
				pw.println("");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		return true;
	}
}
