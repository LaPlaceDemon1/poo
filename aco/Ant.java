package aco;

import graph.*;

import java.util.LinkedList;
import java.util.List;

public class Ant 
{
    double alpha, beta, delta;
    Node current_node;
    List<Integer> visited_nodes;
    List<Edge> path;
    double path_time;
    
    public Ant (double _alpha, double _beta, double _delta, Node inicial_node)
    {
        this.path_time = 0;
        this.alpha = _alpha;
        this.beta = _beta;
        this.delta = _delta;
        visited_nodes = new LinkedList<Integer>();
        path = new LinkedList<Edge>();
        this.current_node = inicial_node;
        visited_nodes.add(inicial_node.getId());
    }


}
