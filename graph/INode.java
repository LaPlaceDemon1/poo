package graph;
import java.util.ArrayList;

public interface INode {
    public int getId();
    public void addEdge(Edge new_Edge);
    public boolean isEqual(Node other_node);
    public ArrayList<Edge> getEdges();

}
