package graph;

import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
    static int [][]edge_matrix;
    int node_number;
    Node[] nodes;

    Graph (int _node_num){
        this.node_number=_node_num;
        this.edge_matrix= new int [_node_num][_node_num];

    }
    int[][] buildGraph(String file_name) {
        String file_path="../maps"+file_name;
        try (BufferedReader reader =new BufferedReader(new FileReader(file_path))){
            String line;
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
