package pec;

import aco.*;
import graph.*;

/**
 * The simulation class is responsible for the simulation of the ant colony
 * optimization algorithm. It contains the pheromone map and the event list.
 *
 */
public class Simulation {

	Pheromones phero;
	EventList simqueue;
	Aco context;
	IGraph graph;

	/**
	 * Creates a new simulation object.
	 *
	 * @param _context has all the information regarding the context
	 * @param _graph   has the graph to be used
	 */
	public Simulation(Aco _context, IGraph _graph) {
		this.context = _context;
		this.graph = _graph;
		phero = new Pheromones(context.getEta(), context.getRho(),
				context.getPheromoneLevel(), context, graph.getEdges());
		simqueue = new EventList();
	}

	/**
	 * Runs the simulation by polling the event list and executing the events
	 * until there are none left.
	 */
	public void run() {
		for (Ant ant : context.getAnts()) {
			simqueue.add(new Move(0.0, ant, context, phero));
		}
		printParameters(this.context, this.graph);

		for (int i = 1; i < 20; i++) {
			simqueue.add(
					new Observation(i * context.getFinalTime() / 20, i, context));
		}
		simqueue.add(new End(context.getFinalTime(), context)); // end of simulation
		while (simqueue.size() > 0) {
			IEvent next = simqueue.removeFirst();
			next.execute(simqueue);
		}
	}

	/**
	 * Prints the parameters of the simulation.
	 *
	 * @param context has all the information regarding the context
	 * @param graph   has the graph to be used
	 */
	public void printParameters(Aco context, IGraph graph) {
		System.out.println("Parameters:");
		System.out.println("Number of nodes:" + context.getNumNodes());
		System.out.println("Nest node:" + context.getNestNode());
		System.out.println("Colony size:" + context.getColonySize());
		System.out.println("Alpha:" + context.getAlpha());
		System.out.println("Beta:" + context.getBeta());
		System.out.println("Delta:" + context.getDelta());
		System.out.println("Eta:" + context.getEta());
		System.out.println("Rho:" + context.getRho());
		System.out.println("Pheromone level:" + context.getPheromoneLevel());
		System.out.println("Final time:" + context.getFinalTime());
		System.out.println("with graph:");
		graph.printGraph();
	}
}
