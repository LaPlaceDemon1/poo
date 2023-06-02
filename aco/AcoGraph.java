package aco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AcoGraph extends Graph {
    int nest_node;
    AcoGraph(int _node_num,int _nest_node) {

        super(_node_num);
        this.nest_node=_nest_node;
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
