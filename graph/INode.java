package graph;
import java.util.ArrayList;

public interface INode {
    /**
     * @return the id of the node
     */
    int getId();
    /**
     * adds edge to the node
     * @param new_Edge the edge to be added to the node
     */
    void addEdge(IEdge new_Edge);
    /**
     * @param other_node the node to be compared to
     * @return true if the nodes are equal, false otherwise
     */
    boolean isEqual(INode other_node);
    /**
     * @return the edges of the node
     */
    ArrayList<IEdge> getEdges();

}
