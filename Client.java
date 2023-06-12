import aco.*;
import graph.*;
import java.util.ArrayList;
/*
parameters:
0  n number of nodes in the graph
1  a max edge weight
2  n1 the nest node
3,4,5  α, β, δ parameters concerning the ant move event
6,7  η, ρ parameters concerning the pheromone evaporation event
8  γ parameter concerning pheromone level
9 ν ant colony size
10 τ final instant

* */
public class Client {
  public static void main(String[] args) {
    Graph main_graph = new Graph();
    if (args.length == 0) {
      // error exit with message invalid input
      System.out.println("Invalid input");
      System.exit(0);
    }
    int i = 0;
    double[] parameters = new double[11];

    // decide if input arguments have flag -r or -f``j
    if (args[0].equals("-r")) {
      // read from command line
      for (i = 1; i < args.length; i++) {
        parameters[i - 1] = Double.parseDouble(args[i]);
      }
      //generate graph
      main_graph.generateGraph(parameters[0], parameters[1]);
    } else if (args[0].equals("-f")) {

      parameters = main_graph.buildGraph(args[1]);
      // read from .txt file
    } else {
      System.out.println("Invalid input");
      // error
    }

    Aco ant_colony = new Aco(parameters[0],parameters[2],parameters[3],
                              parameters[4],parameters[5],parameters[6],
                              parameters[7],parameters[8],parameters[9],
                              parameters[10]
                            );

    Pheromones pheromones =
        new Pheromones(ant_colony.eta, ant_colony.rho,
                       ant_colony.pheromone_level, main_graph.getEdges()
                      );

    ArrayList<Ant> ants = new ArrayList<>();
    for (i = 0; i < ant_colony.colony_size; i++) {
      ants.add(new Ant(
                      (int)ant_colony.num_nodes,ant_colony.alpha, ant_colony.beta, ant_colony.delta,
                      main_graph.getNode( (int)ant_colony.nest_node)
                      ));
    }
  } 
}
