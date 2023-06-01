package aco;

import java.lang.Math;

public class AcoEdge extends Edge 
{
    double pheromone_level = 0;
    double eta;
    double rho;
    int events_since_evaporation = 0;
    

    public AcoEdge (double _weight, int _node0, int _node1, double _eta, double _rho)
    {
        super(_weight, _node0, _node1);
        this.eta = _eta;
        this.rho = _rho;
    }

    public double getPheromone_level()
    {
        return pheromone_level;
    }

    public void layPheromone(double new_pheromone) 
    {
        this.pheromone_level += new_pheromone;
    }

    public void evaporation(double random)
    {
        double probability;

        this.events_since_evaporation++;
        probability = 1 - Math.exp(0-(events_since_evaporation/this.eta));
        
        if (random < probability) this.pheromone_level -= this.rho;

    }
}
