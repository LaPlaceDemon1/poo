package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
    int [][]edge_matrix;
    int node_number;
    Node[] nodes;

    Graph (){
        this.node_number=0;

    }
    public double [] buildGraph(String file_name) {
        String file_path="../maps"+file_name;
        String[] strings;
        double[] parameters = new double[10];
        try (BufferedReader reader =new BufferedReader(new FileReader(file_path))){
            String line;
            if ((line = reader.readLine()) != null) {
                strings = line.split("\t");
                for(int i =0; i<10 ; i++ ){
                    parameters[i] = Double.parseDouble(strings[i]);
                    System.out.println(parameters[i]);
                }
            }

            this.edge_matrix=new int[(int) Math.round(parameters[0])][(int) Math.round(parameters[0])];
            this.node_number=(int) Math.round(parameters[0]);
            int j=0;
            while ((line = reader.readLine()) != null) {

                strings = line.split("\t");

                for (int i=0;i<parameters[0];i++){
                    this.edge_matrix[j][i]=Integer.parseInt(strings[i]);
                }
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return parameters;
    }

}
