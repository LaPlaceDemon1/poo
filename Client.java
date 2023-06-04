import graph.*;

public class Client {
    public void main(String args[])
    {
        Graph main_graph;
        int arguments = args.length;
        if (arguments == 0){
            //error
        }
        int i = 0;

        //decide if input arguments have flag -r or -f
        if (args[0].equals("-r")){
            String[] parameters = new String[arguments-1];
            //read from command line
            for(i=1;i<arguments; i++)
            {
                parameters[i-1] = args[i];
            }
        }
        else if (args[0].equals("-f"){

            double[] parametres_D=main_graph.buildGraph(args[2]);
            //read from .txt file

        }
        else{
            //error
        }
        //if -f, read from .txt file

        //if -r, read from command line



        //read arguments from .txt file

        //read arguments from command line



    }

}