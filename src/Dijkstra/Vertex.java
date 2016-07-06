package Dijkstra;

public class Vertex implements Comparable<Vertex>{
	double dist;
	Edge ed[];
	boolean isVisited;
	int id,parent;
	public Vertex(int id,Edge ed[]) {
		this.id = id;
		this.isVisited = false;
		this.dist = Double.POSITIVE_INFINITY;
		this.parent = -1;
		this.ed = ed;
	}
	public Vertex(Vertex v){
		this.id = v.id;
		this.isVisited = v.isVisited;
		this.dist = v.dist;
		this.parent = v.parent;
		this.ed = new Edge[v.ed.length];
		for (int i = 0; i < ed.length; i++) {
			ed[i] = new Edge(v.ed[i].v1, v.ed[i].weight);
		}
	}
	@Override
	public int compareTo(Vertex o) {
		return ((Double)dist).compareTo(o.dist);
	}
}
