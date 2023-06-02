package aco;

public class AcoEdge extends graph.Edge 
{
    double pheromone_level;
    double eta;
    double rho;
    int events_since_evaporation;
    

    public AcoEdge (double _weight, graph.Node _node0, graph.Node _node1, double _eta, double _rho)
    {
        super(_weight, _node0, _node1);
        this.pheromone_level = 0;
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

    public void evaporation()
    {   
        this.pheromone_level -= this.rho;
    }
}
