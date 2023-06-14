package graph;
import java.util.ArrayList;

public interface INode {
    int getId();
    void addEdge(Edge new_Edge);
    boolean isEqual(Node other_node);
    ArrayList<Edge> getEdges();

}
