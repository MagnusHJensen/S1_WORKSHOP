import java.util.UUID;

public class VentilationActuator extends Actuator {
	public VentilationActuator(String name) {
		this(name, UUID.randomUUID());
	}

	public VentilationActuator(String name, UUID id) {
		super(name, id);
	}

	@Override
	public void setValue(double value) {
		// Black magic!?
		super.setValue(value);
	}

	@Override
	public String toString() {
		return "VentilationActuator{value = " + getValue() + "}";
	}
}
