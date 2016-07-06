package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	ArrayList<Integer> g[];
	final int WHITE = 0,GRAY=1,BLACK = 2;
	int [] pred,color,dist;
	public BFS(ArrayList<Integer> g[]) {
		this.g = g;
		BFSalgo(0);
	}
	private void BFSalgo(int source) {
		init();
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		color[source] = GRAY;
		dist[source] = 0;
		q.add(source);
		while(!q.isEmpty()){
			int u = q.poll();
			color[u] = GRAY;
			for (Integer v : g[u]) {
				if(color[v]==WHITE){
					color[v]=GRAY;
					pred[v] = u;
					dist[v] = dist[u]+1;
					q.add(v);
				}
			}
			color[u] = BLACK;
		}
		
	}
	private void init() {
		int n = g.length;
		pred = new int[n];
		color = new int[n];
		dist = new int[n];
		Arrays.fill(pred, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(color, WHITE);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(5);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[5].add(1);
		g[5].add(6);
		g[6].add(5);
		BFS b = new BFS(g);
		b.printArr();
		System.out.println(b.getPath(0, 5));
	}
	
	private String getPath(int source, int dest) {
		BFSalgo(source);
		if(dist[dest]==Integer.MAX_VALUE) return "";
		String ans=""+dest;
		while(pred[dest]!=-1)
		{
			ans =  pred[dest] +"->"+ans;
			dest = pred[dest];
		}
		return ans;
	}
	public void printArr(){
		System.out.println("====Color====");
		System.out.println(Arrays.toString(color));
		System.out.println("=============");
		System.out.println("====Pred=====");
		System.out.println(Arrays.toString(pred));
		System.out.println("=============");
		System.out.println("====Dist=====");
		System.out.println(Arrays.toString(dist));
		System.out.println("=============");
	}
}
