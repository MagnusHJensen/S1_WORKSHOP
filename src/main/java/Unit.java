import java.util.UUID;

public class Unit {
	private String name;
	private UUID id;

	public Unit(String name) {
		this(name, UUID.randomUUID());
	}

	public Unit(String name, UUID id) {
		this.name = name;
		this.id = id;
	}

	public UUID getID() {
		return this.id;
	}

	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Unit : " + this.name + " , " + this.id + ".";
	}
}
