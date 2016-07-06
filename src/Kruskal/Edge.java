package Kruskal;

public class Edge implements Comparable<Edge>{
	int v1,v2,weight;
	public Edge(int v1,int v2,int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return ((Integer)weight).compareTo(o.weight);
	}
	@Override
	public String toString() {
		return ""+weight;
	}
}
