package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
    double[][] edge_matrix;
    int node_number;
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
}
