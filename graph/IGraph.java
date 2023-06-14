package graph;
import java.util.ArrayList;

public interface IGraph {
    public double[] buildGraph(String file_path);
    public ArrayList<Edge> getEdges();
    public double[] generateGraph(double number_of_nodes, double max_weight);
    public Node getNode(int i);
    public void printGraph();
}