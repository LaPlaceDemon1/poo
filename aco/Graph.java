package aco;

public class Graph {
    int [][]edge_matrix;
    int node_number;
    Nodes [] nodes;

    Graph (int _node_num){
        this.node_number=_node_num;
        this.edge_matrix= new int [_node_num][_node_num];

    }


}
