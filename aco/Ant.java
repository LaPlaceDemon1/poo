package aco;

import graph.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pec.*;

public class Ant {
    int num_nodes;
    double alpha, beta, delta;
    Node current_node;
    ArrayList<Node> visited_nodes;
    ArrayList<Edge> path;
    ArrayList<Double> path_times;

    public Ant(int _num_nodes, double _alpha, double _beta, double _delta,
            Node inicial_node) {
        this.num_nodes = _num_nodes;
        this.path_times = new ArrayList<Double>();
        this.alpha = _alpha;
        this.beta = _beta;
        this.delta = _delta;
        this.visited_nodes = new ArrayList<Node>();
        this.visited_nodes.add(inicial_node);
        this.path = new ArrayList<Edge>();
        this.current_node = inicial_node;
        this.visited_nodes.add(inicial_node);
    }

    public ArrayList<Node> getVisitedNodes() {
        return this.visited_nodes;
    }

    public ArrayList<Integer> getVisitedNodesIDs() {
        ArrayList<Integer> visited_nodes_ids = new ArrayList<Integer>();
        for (Node visitedNode : this.visited_nodes) {
            visited_nodes_ids.add(visitedNode.getId());
        }
        return visited_nodes_ids;
    }

    public double getCost() {
        double cost = 0;
        for (Double pathTime : this.path_times) {
            cost += pathTime;
        }
        return cost;
    }

    public double moveAnt(Pheromones pheromones, EventList sim, double time) {
        Edge next_edge = this.chooseNextEdge(pheromones);
        this.current_node = next_edge.getNext(this.current_node);
        if (this.visited_nodes.contains(next_edge.getNext(this.current_node))) {
            if (!(this.visited_nodes.size() == this.num_nodes)) {
                return next_edge.getWeight() * (-this.delta) *
                        Math.log(1 - Math.random());
            }
        }
        this.path.add(next_edge);
        this.path_times.add(next_edge.getWeight() * (-this.delta) *
                Math.log(1 - Math.random()));
        this.visited_nodes.add(this.current_node);
        if (this.visited_nodes.size() == this.num_nodes + 1) {
            pheromones.lay_pheromone(this.path, sim, time);
        }
        return this.path_times.get(this.path_times.size() - 1);
    }

    private Edge chooseNextEdge(Pheromones pheromones) {
        List<Edge> edges = this.current_node.getEdges();
        List<Edge> unvisited_edges = new LinkedList<Edge>();
        for (Edge edge : edges) {
            if (!this.visited_nodes.contains(edge.getNext(this.current_node))) {
                unvisited_edges.add(edge);
            }
        }
        if (unvisited_edges.size() == 0) {
            // verify if edge.getNext is the same as the first element of
            // visited_nodes
            if (visited_nodes.size() == this.num_nodes) {
                for (Edge edge : edges) {
                    if (edge.getNext(this.current_node).isEqual(visited_nodes.get(0))) {
                        return edge;
                    }
                }
            }

            Edge next_edge = edges.get((int) (Math.random() * edges.size()));
            this.removeCycle(next_edge);
            return next_edge;
        } else {
            double sum = 0;
            for (Edge edge : unvisited_edges) {
                sum += (pheromones.pheromone_map.get(edge) + this.alpha) /
                        (edge.getWeight() + this.beta);
            }
            double random = Math.random() * sum;
            double partial_sum = 0;
            for (Edge edge : unvisited_edges) {
                partial_sum += (pheromones.pheromone_map.get(edge) + this.alpha) /
                        (edge.getWeight() + this.beta);
                if (partial_sum >= random) {
                    return edge;
                }
            }
            return null;
        }
    }

    private void removeCycle(Edge next_edge) {
        Node node_to_keep = next_edge.getNext(this.current_node);
        int index = this.visited_nodes.indexOf(node_to_keep);

        for (int i = this.visited_nodes.size(); i < index;) {
            this.visited_nodes.remove(i);
            this.path.remove(i - 1);
            this.path_times.remove(i - 1);
        }
    }
}
