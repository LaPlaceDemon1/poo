package aco;
import graph.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Aco {
    public double num_nodes, nest_node, colony_size;
    public double alpha, beta, delta, eta, rho, pheromone_level, final_time;
    public double num_movs, num_evap;
    public PriorityQueue<Cycle> cycles;
    ArrayList<Ant> ants;
    public Aco(double _num_nodes, double _nest_node, double _alpha, double _beta,
            double _delta, double _eta, double _rho, double _pheromone_level,
            double _colony_size, double _final_time, Graph graph){
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
        ants = new ArrayList<>();
        for (int i = 0; i < this.colony_size; i++) {
            ants.add(new Ant(
                    (int)this.num_nodes,this.alpha, this.beta, this.delta,
                    graph.getNode( (int)this.nest_node)
            ));
        }
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

    public double getBeta() {
        return this.beta;
    }

    public double getDelta() {
        return this.delta;
    }

    public double getEta() {
        return this.eta;
    }

    public double getRho() {
        return this.rho;
    }

    public double getPheromoneLevel() {
        return this.pheromone_level;
    }

    public double getFinalTime() {
        return this.final_time;
    }

    public double getNumMovs() {
        return this.num_movs;
    }

    public double getNumEvap() {
        return this.num_evap;
    }

    public ArrayList<Ant> getAnts() {
        return this.ants;
    }

    public void printTopCycles() {
        if (this.cycles.size() > 0) {
            ArrayList<Cycle> aux = new ArrayList<Cycle>();
            for (int i = 0; (i < this.cycles.size()) || (i < 5); i++) {
                aux.add(this.cycles.poll());
                aux.get(i).printCycle();
            }
        } else {
            System.out.println("\t\t{}");
        }
    }

    public void printBestCycle() {
        if (this.cycles.size() > 0) {
            Cycle best = this.cycles.poll();
            best.printCycle();
            cycles.add(best);
        } else {
            System.out.println("\t\t{}");
        }
    }

    public void addCycle(Cycle cycle) {
        this.cycles.add(cycle);
    }
}
