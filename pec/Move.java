package pec;

import aco.*;

public class Move extends Event{
	public Move(Double _time,Pheromones pheromones){
		super(_time);
		move(pheromones);


	}
}
