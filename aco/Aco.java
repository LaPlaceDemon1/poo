package aco;

import graph.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Aco {
    double num_nodes, nest_node, colony_size;
    double alpha, beta, delta, eta, rho, pheromone_level, final_time;
    int num_movs, num_evap;
    PriorityQueue<Cycle> cycles;
    ArrayList<Ant> ants;

    public Aco(double _num_nodes, double _nest_node, double _alpha, double _beta,
            double _delta, double _eta, double _rho, double _pheromone_level,
            double _colony_size, double _final_time, Graph graph) {
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
        this.num_movs = 0;
        this.num_evap = 0;
        this.cycles = new PriorityQueue<>(Cycle::compareTo);
        ants = new ArrayList<>();
        for (int i = 0; i < this.colony_size; i++) {
            ants.add(new Ant((int) this.num_nodes, this.alpha, this.beta, this.delta,
                    graph.getNode((int) this.nest_node)));
        }
    }

    /**
     * @return the num_nodes
     */
    public double getNumNodes() {
        return this.num_nodes;
    }
    /**
     * @return the nest_node
     */
    public double getNestNode() {
        return this.nest_node;
    }
    /**
     * @return the colony_size
     */
    public double getColonySize() {
        return this.colony_size;
    }
    /**
     * @return pheromone wheight on next move
     */
    public double getAlpha() {
        return this.alpha;
    }
    /**
     * @return wheight wheight on next move
     */
    public double getBeta() {
        return this.beta;
    }
    /**
     * @return mean of the distribution of the time needed to move to the next node
     */
    public double getDelta() {
        return this.delta;
    }
    /**
     * @return mean of the distribution of the time until next pheromone evaporation
     */
    public double getEta() {
        return this.eta;
    }
    /**
     * @return constant of the pheromones decrease
     */
    public double getRho() {
        return this.rho;
    }
    /**
     * @return constant of the pheromones laid
     */
    public double getPheromoneLevel() {
        return this.pheromone_level;
    }
    /**
     * @return final instant
     */
    public double getFinalTime() {
        return this.final_time;
    }
    /**
     * @return the number of movements
     */
    public double getNumMovs() {
        return this.num_movs;
    }
    /**
     * @return the number of evaporation
     */
    public double getNumEvap() {
        return this.num_evap;
    }
    public ArrayList<Ant> getAnts() {
        return this.ants;
    }
    /**
     * increment the number of movements
     */
    public void incNumMovs() {
        this.num_movs++;
    }
    /**
     * increment the number of evaporation
     */
    public void incNumEvap() {
        this.num_evap++;
    }
    /**
     * prints the best cycles
     */
    public void printTopCycles() {
        if (this.cycles.size() > 0) {
            ArrayList<Cycle> aux = new ArrayList<>();
            for (int i = 0; (i < this.cycles.size()) && (i < 5); i++) {
                aux.add(this.cycles.poll());
            }
            for (Cycle cycle : aux) {
                cycle.printCycle();
                this.cycles.add(cycle);
            }
        } else {
            System.out.println("\t\t{}");
        }
    }
    /**
     * prints the best cycle
     */
    public void printBestCycle() {
        if (this.cycles.size() > 0) {
            Cycle best = this.cycles.poll();
            best.printCycle();
            cycles.add(best);
        } else {
            System.out.println("\t\t{}");
        }
    }
    /**
     * adds a cycle to the list of cycles
     */
    public void addCycle(Cycle cycle) {
        this.cycles.add(cycle);
    }
}
