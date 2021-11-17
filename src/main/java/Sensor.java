import java.util.UUID;

public class Sensor extends Unit {

	public Sensor(String name) {
		this(name, UUID.randomUUID());
	}

	public Sensor(String name, UUID id) {
		super(name, id);
	}

	public double getValue() {
		return Math.random();
	}
}
