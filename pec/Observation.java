package pec;

import aco.*;

/**
 * This class represents an observation event.
 * Show the state of the simulation.
 * Can be scheduled to infer if the simulation is stalled or in progress.
 */
public class Observation extends Event {
  Aco context;
  int number;

  /**
   * Creates a new observation event.
   *
   * @param _time   the time of the event
   * @param _number the number of the event
   * @param aco     has all the information regarding the context
   */
  public Observation(double _time, int _number, Aco aco) {
    super(_time);
    this.number = _number;
    context = aco;
  }

  // override execute
  /**
   * Prints the state of the simulation.
   *
   * @param sim the event list
   */
  @Override
  public void execute(EventList sim) {
    System.out.println("Observation " + this.number);
    System.out.println("\tPresent instant:" + this.time);
    System.out.println("Number of move events:" + context.getNumMovs());
    System.out.println("Number of evaporation events:" + context.getNumEvap());
    System.out.println("\tTop candidate cycles:");
    context.printTopCycles();
    System.out.println("Best Hamiltonian cycle:");
    context.printBestCycle();
  }
}
