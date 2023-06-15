package graph;
import java.util.ArrayList;

public interface IGraph {
    double[] buildGraph(String file_path);
    ArrayList<IEdge> getEdges();
    double[] generateGraph(double number_of_nodes, double max_weight);
    INode getNode(int i);
    void printGraph();
}