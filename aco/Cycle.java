package aco;

import java.util.ArrayList;

public class Cycle {
  ArrayList<Integer> nodes;
  double cost;

  public Cycle(ArrayList<Integer> _nodes, double _cost) {
    this.nodes = _nodes;
    this.cost = _cost;
  }

  public void printCycle() {
    System.out.print("\t\t{");
    for (int i = 0; i < this.nodes.size(); i++) {
      System.out.print(this.nodes.get(i));
      if (i < this.nodes.size() - 1) {
        System.out.print(", ");
      }
      System.out.println("}: " + this.cost);
    }
  }

  public int compareTo(Cycle that) {
    return Double.compare(that.cost, this.cost);
  }
}
