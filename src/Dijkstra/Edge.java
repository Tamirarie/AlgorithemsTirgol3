package Dijkstra;

public class Edge{
	int v1,weight;
	public Edge(int v1,int weight) {
		this.v1 = v1;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return ""+weight;
	}
	
}
