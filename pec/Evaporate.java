package pec;

import aco.*;
import graph.*;
import java.util.Random;

public class Evaporate extends Event {
	IEdge phero_edge;
	Pheromones pheromones;
	Aco context;
	Double exp_mean;

	public Evaporate(double _time, Pheromones _pheromones, Aco _context,
			IEdge _phero_edge, Double _exp_mean) {
		super(_time);
		phero_edge = _phero_edge;
		context = _context;
		pheromones = _pheromones;
		exp_mean = _exp_mean;
	}

	private void schedule_next(EventList sim, Evaporate next) {
		sim.add(next);
	}

	@Override
	public void execute(EventList sim) {
		Random random = new Random();
		double randomValue = -exp_mean * Math.log(1 - random.nextDouble());
		this.context.incNumEvap();

		pheromones.evaporation(phero_edge);
		schedule_next(sim, new Evaporate(time + randomValue, pheromones, context,
				phero_edge, exp_mean));
	}
}
