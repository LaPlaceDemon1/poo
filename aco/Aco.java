package aco;

import java.util.PriorityQueue;

// definir o numero das vareaveis dos parametros como o nome dos parametros
public class Aco {
    public double num_nodes, nest_node, colony_size;
    public double alpha, beta, delta, eta, rho, pheromone_level, final_time;
    public double num_movs, num_evap;
    public PriorityQueue<Cycle> cycles;

    public Aco(double _num_nodes, double _nest_node, double _alpha, double _beta,
            double _delta, double _eta, double _rho, double _pheromone_level,
            double _colony_size, double _final_time) {
        this.num_nodes = _num_nodes;
        this.nest_node = _nest_node;
        this.colony_size = _colony_size;
        this.alpha = _alpha;
        this.beta = _beta;
        this.delta = _delta;
        this.eta = _eta;
        this.rho = _rho;
        this.pheromone_level = _pheromone_level;
        this.final_time = _final_time;
        this.cycles = new PriorityQueue<Cycle>();
    }

    public double getNumNodes() {
        return this.num_nodes;
    }

    public double getNestNode() {
        return this.nest_node;
    }

    public double getColonySize() {
        return this.colony_size;
    }

    public double getAlpha() {
        return this.alpha;
    }
}
