package aco;

import graph.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import pec.*;

public class Pheromones {
    double eta, rho, pheromone_level;
    Map<Edge, Double> pheromone_map;

    public Pheromones(double _eta, double _rho, double _pheromone_level,
            ArrayList<Edge> edges) {
        this.eta = _eta;
        this.rho = _rho;
        this.pheromone_level = _pheromone_level;
        this.pheromone_map = new HashMap<Edge, Double>();
        for (Edge edge : edges) {
            this.pheromone_map.put(edge, 0.0d);
        }
    }

    // evaporation event: the given edge has its correspnding pheromone level from
    // pheromone_map reduced by rho, if the pheromone level is less than 0, it is
    // set to 0 and the method returns false, otherwise it returns true
    public boolean evaporation(Edge edge) {
        double new_pheromone_level = this.pheromone_map.get(edge) - this.rho;
        if (new_pheromone_level < 0) {
            this.pheromone_map.put(edge, 0.0d);
            return false;
        } else {
            this.pheromone_map.put(edge, new_pheromone_level);
            return true;
        }
    }

    // lay pheromone event: the given edge has its corresponding pheromone level
    // from pheromone_map increased by pheromone_level
    void lay_pheromone(ArrayList<Edge> edges, EventList sim, double time) {
        Random random = new Random();
        double total_weight = 0;
        for (Edge edge : edges) {
            if (this.pheromone_map.get(edge) == 0)
                ;
            sim.add(
                    new Evaporate(time + -this.eta * Math.log(1 - random.nextDouble()),
                            this, edge, this.eta));

            total_weight += edge.getWeight();
        }
        for (Edge edge : edges) {
            double new_pheromone_level = this.pheromone_map.get(edge) +
                    ((this.pheromone_level * edge.getWeight()) / total_weight);
            this.pheromone_map.put(edge, new_pheromone_level);
        }
    }

    // get the pheromone level of the given edge
    double get_pheromone_level(Edge edge) {
        return this.pheromone_map.get(edge);
    }
}
