package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph implements IGraph {
    double[][] edge_matrix;
    int node_number;
    int failsafe;
    ArrayList<INode> nodes;
    ArrayList<IEdge> edges;

    public Graph() {
        this.node_number = 0;
        this.failsafe = 0;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public double[] buildGraph(String file_path) {
        String[] strings;
        double[] parameters = new double[11];
        int j = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            if ((line = reader.readLine()) != null) {
                strings = line.split("\t");
                for (int i = 0; i < 11; i++) {
                    if (i == 1) {
                        parameters[i] = -1;
                        i++;
                    }
                    parameters[i] = Double.parseDouble(strings[j]);
                    System.out.print(parameters[i] + " ");
                    j++;
                }
                System.out.println();
            }

            this.edge_matrix = new double[(int) Math.round(parameters[0])][(int) Math.round(parameters[0])];
            this.node_number = (int) Math.round(parameters[0]);
            for (int i = 0; i < parameters[0]; i++) {
                line = reader.readLine();
                strings = line.split("\t");
                for (j = 0; j < parameters[0]; j++) {
                    this.edge_matrix[j][i] = Double.parseDouble(strings[j]);
                }
            }
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.doTheNodesNEdges();
        return parameters;
    }

    void doTheNodesNEdges() {
        this.nodes = new ArrayList<>();
        for (int i = 0; i < this.node_number; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < this.node_number; i++) {
            for (int j = 0; j < this.node_number; j++) {
                if (this.edge_matrix[i][j] != 0) {
                    if (i < j) {
                        IEdge e = new Edge(edge_matrix[i][j], nodes.get(i), nodes.get(j));
                        edges.add(e);
                        nodes.get(i).addEdge(e);
                        nodes.get(j).addEdge(e);
                    }
                }
            }
        }
    }

    public ArrayList<IEdge> getEdges() {
        return edges;
    }

    public double[] generateGraph(double number_of_nodes, double max_weight) {

        // genereate a random hamiltionian cycle with number of nodes and max weight
        double[] parameters = new double[10];
        parameters[0] = number_of_nodes;
        parameters[1] = max_weight;
        this.node_number = (int) Math.round(parameters[0]);
        this.edge_matrix = new double[(int) Math.round(parameters[0])][(int) Math.round(parameters[0])];
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        for (int i = 0; i < this.node_number; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < this.node_number; i++) {
            for (int j = 0; j < this.node_number; j++) {
                if (i < j) {
                    double weight = Math.random() * parameters[1];
                    this.edge_matrix[i][j] = weight;
                    this.edge_matrix[j][i] = weight;
                    Edge e = new Edge(weight, nodes.get(i), nodes.get(j));
                    edges.add(e);
                    nodes.get(i).addEdge(e);
                    nodes.get(j).addEdge(e);
                }
            }
        }

        // verify if the graph has a hamiltionian cycle
        boolean has_hamiltionian_cycle = false;
        for (int i = 0; i < this.node_number; i++) {
            if (nodes.get(i).getEdges().size() < 2) {
                has_hamiltionian_cycle = false;
                break;
            } else {
                has_hamiltionian_cycle = true;
            }
        }
        if (!has_hamiltionian_cycle) {
            failsafe++;
            if (failsafe > 100) {
                System.out.println(
                        "Failed to generate a graph with a hamiltionian cycle");
                System.exit(0);
            }
            generateGraph(number_of_nodes, max_weight);
        }

        // print the hamiltionian cycle graph
        System.out.println("Generated graph with " + this.node_number +
                " nodes and max weight of " + parameters[1]);
        for (int i = 0; i < this.node_number; i++) {
            for (int j = 0; j < this.node_number; j++) {
                System.out.print(this.edge_matrix[i][j] + "\t");
            }
            System.out.println();
        }

        return parameters;
    }

    public INode getNode(int i) {
        return nodes.get(i);
    }

    public void printGraph() {
        for (int i = 0; i < this.node_number; i++) {
            System.out.println("\t\t");
            for (int j = 0; j < this.node_number; j++) {
                System.out.print(this.edge_matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
