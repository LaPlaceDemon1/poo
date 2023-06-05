package aco;

import java.util.ArrayList;
import java.util.Map;
import graph.*;
public class Pheromones 
{
    double eta, rho;
    Map<Edge, Double> pheromone_map;

    Pheromones(double _eta, double _rho)
    {
        this.eta = _eta;
        this.rho = _rho;
    }

    //evaporation event: the given edge has its correspnding pheromone level from pheromone_map reduced by rho, if the pheromone level is less than 0, it is set to 0
    //and the method returns false, otherwise it returns true
    boolean evaporation(Edge edge)
    {
        double new_pheromone_level = this.pheromone_map.get(edge) - this.rho;
        if (new_pheromone_level < 0)
        {
            this.pheromone_map.put(edge, 0.0d);
            return false;
        }
        else
        {
            this.pheromone_map.put(edge, new_pheromone_level);
            return true;
        }
    }
    
    //lay pheromone event: the given edge has its corresponding pheromone level from pheromone_map increased by pheromone_level
    void lay_pheromone(ArrayList<Edge> edges, double pheromone_level)
    {
        double total_weight = 0;
        for (Edge edge : edges)
        {
            total_weight += edge.getWeight();
        }
        for (Edge edge : edges)
        {
            double new_pheromone_level = this.pheromone_map.get(edge) + ((pheromone_level*edge.getWeight())/total_weight);
            this.pheromone_map.put(edge, new_pheromone_level);
        }
    }

    //get the pheromone level of the given edge
    double get_pheromone_level(Edge edge)
    {
        return this.pheromone_map.get(edge);
    }




}