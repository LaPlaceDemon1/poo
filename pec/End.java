package pec;

import aco.*;

public class End extends Event {
	Aco context;

	public End(double _time) {
		super(_time);
	}

	// override execute
	@Override
	public void execute(EventList sim) {
		System.out.println("Observation 20:");
		System.out.println("\tPresent instant:" + context.getFinalTime());
		System.out.println("\tTop candidate cycles:");
		context.printTopCycles();
		System.out.println("Number of move events:" + context.getNumMovs());
		System.out.println("Number of evaporation events:" + context.getNumEvap());
		System.out.println("Best Hamiltonian cycle:");
		System.out.println("End of simulation");
	}
}
