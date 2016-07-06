package Prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {
	final int WHITE = 0, GRAY = 1, BLACK = 2, inf = Integer.MAX_VALUE;
	int [] pred,weight,color;
	int sizeTree,sumTree;
	Edge tree[];
	ArrayList<Node> g[];
	public Prim(ArrayList<Node> g[]) {
		this.g = g;
		int n = g.length;
		pred = new int[n];
		weight = new int[n];
		color = new int[n];
		Arrays.fill(color, WHITE);
		Arrays.fill(pred, -1);
		Arrays.fill(weight, inf);
		tree = new Edge[n-1];
		buildMST(0);
		makeMST();
	}
	private void makeMST() {
		sumTree=sizeTree=0;
		for (int i = 0; i < g.length; i++) {
			if(pred[i]!=-1){
				tree[sizeTree++] = new Edge(i, pred[i], weight[i]);
				sumTree+= weight[i];
			}
		}
	}
	private void buildMST(int root) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(root, 0));
		weight[root] = 0;
		color[root] = GRAY;
		while(!q.isEmpty()){
			Node v = q.poll();
			int u = v.id;
			color[u] = GRAY;
			for (Node n : g[u]) {
				if(color[n.id] == WHITE){
					color[n.id] = GRAY;
					pred[n.id] = u;
					weight[n.id] = n.weight;
					q.add(new Node(n.id, n.weight));
				}
				else if(color[n.id] == GRAY){
					if(weight[n.id] > n.weight){
						weight[n.id] = n.weight;
						pred[n.id] = u;
					}
				}
			}
			color[u] = BLACK;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Node> g [] = initGraph();
		Prim p =new Prim(g);
		System.out.println(p.sumTree);
		System.out.println(Arrays.toString((p.tree)));
	}
	
	public static ArrayList<Node>[] initGraph(){
		ArrayList<Node>[] g = new ArrayList[5];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(new Node(1,4));
		g[0].add(new Node(4,5));
		
		g[1].add(new Node(0,4));
		g[1].add(new Node(2,3));
		g[1].add(new Node(3,6));
		g[1].add(new Node(4,1));
		
		g[2].add(new Node(1,3));
		g[2].add(new Node(3,6));
		g[2].add(new Node(4,2));
		
		g[3].add(new Node(1,6));
		g[3].add(new Node(2,6));
		g[3].add(new Node(4,7));

		g[4].add(new Node(0,5));
		g[4].add(new Node(1,1));
		g[4].add(new Node(2,2));
		g[4].add(new Node(3,7));

		return g;
	}
}
