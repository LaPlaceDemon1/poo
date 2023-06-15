package graph;
import java.util.ArrayList;

public interface INode {
    int getId();
    void addEdge(IEdge new_Edge);
    boolean isEqual(INode other_node);
    ArrayList<IEdge> getEdges();

}
