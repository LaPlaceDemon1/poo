package graph;

public interface IEdge {
    /**
     * @return the weight of the edge
     */
    double getWeight();

    /**
     * @return the node on the other side of the edge
     */
    INode getNext(INode currentNode);
}
