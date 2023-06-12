package pec;

public class End extends Event {
	public End(double _time) {
		super(_time);

	}
	//override execute
	@Override
	public void execute(EventList sim) {
		System.out.println("End of simulation");
	}

}
