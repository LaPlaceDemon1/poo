package pec;
import graph.*;
import aco.Pheromones;

public class Simulation {
	//aqui é onde a magia acontece
	public Simulation(double[] arguments){

		Pheromones phero= new Pheromones(arguments[0],arguments[0],arguments[0],null);//mudar os argumentos
		EventList simqueue= new EventList();
		simqueue.add(null);

		while(simqueue.size()>0){
			Event next=simqueue.removeFirst();
			next.execute(simqueue);
		}




	}
}
