package Euler;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Euler {
	boolean isPath,isCycle;
	int v_start,deg[];
	ArrayList<Integer> g[];
	public Euler(ArrayList<Integer> g[]) {
		this.g = g;
		init();
	}
	private void init() {
		int n = g.length;
		deg = new int [n];
		int numOfOdd=0;
		for (int i = 0; i < deg.length; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2==1){
				numOfOdd++;
				v_start = i;
			}
		}
		if(numOfOdd==0) isPath=isCycle=true;
		else if(numOfOdd==2) isPath = true;
	}
	
	private String algo() {
		String ans = "";
		Stack <Integer>s = new Stack<>();
		s.add(v_start);
		while(!s.isEmpty()){
			int v = s.peek();
			if(deg[v]==0){
				s.pop();
				ans+=v;
			}
			else{
				int u = g[v].get(0);
				deg[u]--;
				deg[v]--;
				g[u].remove((Integer)v);
				g[v].remove((Integer)u);
				s.push(u);
			}
		}
		
		return ans;
	}
	
	public String getPath(){
		if(!isPath) return null;
		return algo();
	}
	
	public String getCycle(){
		if(!isCycle) return null;
		return algo();
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
	//	g[0].add(1);
		g[0].add(4);
	//	g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(5);
		g[4].add(0);
		g[4].add(5);
		g[5].add(4);
		g[5].add(3);
		Euler e = new Euler(g);
		System.out.println(e.getPath());
	}
}
