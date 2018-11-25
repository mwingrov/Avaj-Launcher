package aircraft;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(String name, Coordinates coordinates){
		super();
		this.name = name;
		this.coordinates = coordinates;
		nextId();
	}

	public long nextId(){
		return id;
	}
}