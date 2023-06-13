package pec;

import aco.*;

public class Move extends Event {
	Ant ant;
	Pheromones pheromones;
	Aco context;

	public Move(Double _time, Ant _ant, Aco _context, Pheromones _pheromones) {
		super(_time);
		context = _context;
		ant = _ant;
		pheromones = _pheromones;
	}

	@Override
	public void execute(EventList sim) {
		double next_time = ant.moveAnt(pheromones, sim, this.time);
		this.context.incNumMovs();
		this.schedule_next(sim,
				new Move(time + next_time, ant, context, pheromones));
	}
}
