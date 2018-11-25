package aircraft;

public class Aircraft {

	protected long id = 0L;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0L;

	protected Aircraft(String name, Coordinates coordinates){
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	protected Aircraft() {
		return ;
	}

	public long nextId(){
		return ++this.idCounter;
	}
}