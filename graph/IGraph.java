package graph;

import java.util.ArrayList;

public interface IGraph {
    /**
     * build graph:
     * stores the graph in the graph object as an edge matrix and as nodes and
     * edges
     *
     * @param file_path: path to the file that contains the graph
     */
    double[] buildGraph(String file_path);

    /**
     * gets the list of all edges in the graph
     *
     * @return ArrayList
     */
    ArrayList<IEdge> getEdges();

    /**
     * generates a random graph with the given number of nodes and max weight of
     * an edge
     *
     * @param number_of_nodes number of nodes in the graph
     * @param max_weight      max weight of an edge
     * @return parameters of the graph by index: 0: number of nodes, 1: max weight
     *         of an edge, 2:nest node, 3: pheromone wheight on next move,
     *         4:wheight wheight on next move, 5: mean of the distribution of the
     *         time
     *         needed to move to the next node, 6: mean of the distribution of the
     *         time
     *         until next pheromone evaporation, 7: constant of the pheromones
     *         decrease,
     *         8: constant of the pheromones laid, 9: number of ants, 10: final
     *         instant
     */
    double[] generateGraph(double number_of_nodes, double max_weight);

    /**
     * getter of the node with the given index
     *
     * @return Node reference
     * @param i index of the node
     */
    INode getNode(int i);

    /**
     * prints the graph
     */
    void printGraph();
}
