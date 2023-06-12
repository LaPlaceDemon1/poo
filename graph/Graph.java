package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Graph {
    double[][] edge_matrix;
    int node_number;
    int failsafe = 0;
    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public Graph() {
        this.node_number = 0;
    }

    public double[] buildGraph(String file_path) {
        String[] strings;
        double[] parameters = new double[10];
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
            String line;
            if ((line = reader.readLine()) != null) {
                strings = line.split("\t");
                for (int i = 0; i < 10; i++) {
                    parameters[i] = Double.parseDouble(strings[i]);
                    System.out.println(parameters[i]);
                }
            }

            this.edge_matrix = new double[(int) Math.round(parameters[0])][(int) Math.round(parameters[0])];
            this.node_number = (int) Math.round(parameters[0]);
            int j = 0;
            while ((line = reader.readLine()) != null) {

                strings = line.split("\t");

                for (int i = 0; i < parameters[0]; i++) {
                    this.edge_matrix[j][i] = Double.parseDouble(strings[i]);
                }
                System.out.println(line);
            }
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
                        Edge e = new Edge(edge_matrix[i][j], nodes.get(i), nodes.get(j));
                        edges.add(e);
                        nodes.get(i).addEdge(e);
                        nodes.get(j).addEdge(e);
                    }
                }
            }
        }
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public double[] generateGraph(double number_of_nodes, double max_weight) {
    
        //genereate a random hamiltionian cycle with number of nodes and max weight
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

        //verify if the graph has a hamiltionian cycle
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
                System.out.println("Failed to generate a graph with a hamiltionian cycle");
                System.exit(0);
            }
            generateGraph(number_of_nodes, max_weight);
        }


        return parameters;
    }
}

