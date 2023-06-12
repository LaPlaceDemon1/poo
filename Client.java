import aco.*;
import graph.*;
import java.util.ArrayList;

public class Client {
  public static void main(String args[]) {
    Graph main_graph = new Graph();
    if (args.length == 0) {
      // error
    }
    int i = 0;
    double[] parameters = new double[10];

    // decide if input arguments have flag -r or -f``j
    if (args[0].equals("-r")) {
      // read from command line
      for (i = 1; i < args.length; i++) {
        parameters[i - 1] = Double.parseDouble(args[i]);
      }
      //generate graph
      main_graph.generateGraph(parameters[0], parameters[1]);
    } else if (args[0].equals("-f")) {

      double[] parametres = main_graph.buildGraph(args[1]);
      // read from .txt file
    } else {
      // error
    }
/*
    Aco ant_colony = new Aco(parameters[0], parameters[1], parameters[3],
                             parameters[4], parameters[5], parameters[6],
                             parameters[7], parameters[8], parameters[9]);

    Pheromones pheromones =
        new Pheromones(ant_colony.eta, ant_colony.rho,
                       ant_colony.pheromone_level, main_graph.getEdges());

    ArrayList<Ant> ants = new ArrayList<>();
    for (i = 0; i < ant_colony.colony_size; i++) {
      ants.add(
        new Ant(ant_colony.alpha, ant_colony.beta, ant_colony.delta,
          main_graph.getNodes().get(Integer parseInteger(
                     ant_colony.nest_node)))); // TODO solve error nest node
    } */
  } 
}
