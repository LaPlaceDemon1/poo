package pec;

import aco.*;
import graph.*;

public class Simulation {
	// aqui é onde a magia acontece

	Pheromones phero;
	EventList simqueue;

	public Simulation(Aco context, Graph graph) {

		phero = new Pheromones(context.getEta(),context.getRho(),context.getPheromoneLevel(),graph.getEdges());
		simqueue = new EventList();
		simqueue.add(null);
	}

	public void run() {
		while (simqueue.size() > 0) {
			Event next = simqueue.removeFirst();
			next.execute(simqueue);
		}
	}

	public void end(Aco context) {
	}

	public void checkpoint(Aco context, Double time) {
		System.out.println("checkpoint:");
		System.out.println("present instant:" + time);
		System.out.println("Top candidate cycles:");
		System.out.println("Number of move events:" + context.getNumMovs());
		System.out.println("Best Hamiltonian cycle: :");
	}
}
