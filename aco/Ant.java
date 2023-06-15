package aco;

import graph.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pec.*;

public class Ant {
    int num_nodes;
    double alpha, beta, delta;
    INode current_node;
    ArrayList<INode> visited_nodes;
    ArrayList<IEdge> path;

    public Ant(int _num_nodes, double _alpha, double _beta, double _delta,
            INode inicial_node) {
        this.num_nodes = _num_nodes;
        this.alpha = _alpha;
        this.beta = _beta;
        this.delta = _delta;
        this.visited_nodes = new ArrayList<INode>();
        this.visited_nodes.add(inicial_node);
        this.path = new ArrayList<IEdge>();
        this.current_node = inicial_node;
    }

    public ArrayList<INode> getVisitedNodes() {
        return this.visited_nodes;
    }

    public ArrayList<Integer> getVisitedNodesIDs() {
        ArrayList<Integer> visited_nodes_ids = new ArrayList<Integer>();
        for (INode visitedNode : this.visited_nodes) {
            visited_nodes_ids.add(visitedNode.getId());
        }
        return visited_nodes_ids;
    }

    public double getCost() {
        double cost = 0;
        for (IEdge edge : this.path) {
            cost += edge.getWeight();
        }
        return cost;
    }

    public double moveAnt(Pheromones pheromones, EventList sim, double time) {
        IEdge next_edge = this.chooseNextEdge(pheromones);
        double next_time = next_edge.getWeight() * (-this.delta) * Math.log(1 - Math.random());
        if (this.visited_nodes.contains(next_edge.getNext(this.current_node))) {
            if (!(this.visited_nodes.size() == this.num_nodes)) {
                this.current_node = next_edge.getNext(this.current_node);
                return next_time;
            }
        }
        this.path.add(next_edge);
        this.current_node = next_edge.getNext(this.current_node);
        this.visited_nodes.add(this.current_node);
        if (this.visited_nodes.size() == this.num_nodes + 1) {
            pheromones.lay_pheromone(this.path, sim, time);
        }
        return next_time;
    }


    /**
     * This method chooses the next edge to be visited by the ant
     * based on the pheromone levels and the weight of the edges available.
     * @param pheromones
     * @return
     */

    private IEdge chooseNextEdge(Pheromones pheromones) {
        List<IEdge> edges = this.current_node.getEdges();
        List<IEdge> unvisited_edges = new LinkedList<IEdge>();
        for (IEdge edge : edges) {
            if (!this.visited_nodes.contains(edge.getNext(this.current_node))) {
                unvisited_edges.add(edge);
            }
        }
        if (unvisited_edges.size() == 0) {
            // verify if edge.getNext is the same as the first element of
            // visited_nodes
            if (visited_nodes.size() == this.num_nodes) {
                for (IEdge edge : edges) {
                    if (edge.getNext(this.current_node).isEqual(visited_nodes.get(0))) {
                        return edge;
                    }
                }
            }

            IEdge next_edge = edges.get((int) (Math.random() * edges.size()));
            this.removeCycle(next_edge);
            return next_edge;
        } else {
            double sum = 0;
            for (IEdge edge : unvisited_edges) {
                sum += (pheromones.pheromone_map.get(edge) + this.alpha) /
                        (edge.getWeight() + this.beta);
            }
            double random = Math.random() * sum;
            double partial_sum = 0;
            for (IEdge edge : unvisited_edges) {
                partial_sum += (pheromones.pheromone_map.get(edge) + this.alpha) /
                        (edge.getWeight() + this.beta);
                if (partial_sum >= random) {
                    return edge;
                }
            }
            return null;
        }
    }

    /**
     * When the ant finds a cycle that is not hamiltonian
     * it removes the cycle to forget the bad path. 
     * 
     * @param next_edge
     * 
     */


    private void removeCycle(IEdge next_edge) {
        INode node_to_keep = next_edge.getNext(this.current_node);
        int index = this.visited_nodes.indexOf(node_to_keep);

        for (int i = this.visited_nodes.size() - 1; i > index; i--) {
            this.visited_nodes.remove(i);
            this.path.remove(i - 1);
        }
    }
}
