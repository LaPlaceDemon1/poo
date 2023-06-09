package pec;
import aco.*;
import graph.*;
public class Evaporate extends Event {
	Edge phero_edge;
	Evaporate(double _time){
		this.time = 0;
	}

	@Override
	public void execute() {
		pheromones.evaporation(phero_edge);
	}
}
