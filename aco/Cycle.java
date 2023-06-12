package aco;

public class Cycle {
  int[] nodes;
  double cost;

  public Cycle(int[] _nodes, double _cost) {
    this.nodes = _nodes;
    this.cost = _cost;
  }

  public void printCycle() {
    System.out.print("\t\t{");
    for (int i = 0; i < this.nodes.length; i++) {
      System.out.print(this.nodes[i]);
      if (i < this.nodes.length - 1) {
        System.out.print(", ");
      }
      System.out.println("}: " + this.cost);
    }
  }

  public int compareTo(Cycle other) {
    if (this.cost < other.cost) {
      return -1;
    } else if (this.cost > other.cost) {
      return 1;
    } else {
      return 0;
    }
  }
}
