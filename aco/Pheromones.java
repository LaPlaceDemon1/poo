package aco;

import java.util.Map;
import graph.*;
public class Pheromones 
{
    float eta, rho, pheromone_level;
    Map<Edge, Float> pheromone_map;

    Pheromones(float _eta, float _rho, float _pheromone_level)
    {
        this.eta = _eta;
        this.rho = _rho;
        this.pheromone_level = _pheromone_level;
    }

    //evaporation event: the given edge has its correspnding pheromone level from pheromone_map reduced by rho, if the pheromone level is less than 0, it is set to 0
    //and the method returns false, otherwise it returns true
    boolean evaporation(Edge edge)
    {
        float new_pheromone_level = this.pheromone_map.get(edge) - this.rho;
        if (new_pheromone_level < 0)
        {
            this.pheromone_map.put(edge, 0.0f);
            return false;
        }
        else
        {
            this.pheromone_map.put(edge, new_pheromone_level);
            return true;
        }
    }
    
    //lay pheromone event: the given edge has its corresponding pheromone level from pheromone_map increased by pheromone_level
    void lay_pheromone(Edge edge)
    {
        float new_pheromone_level = this.pheromone_map.get(edge) + this.pheromone_level;
        this.pheromone_map.put(edge, new_pheromone_level);
    }

    //get the pheromone level of the given edge
    float get_pheromone_level(Edge edge)
    {
        return this.pheromone_map.get(edge);
    }




}