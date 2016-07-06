package Kruskal;

import java.util.Arrays;

public class Kruskal {
	DisjointSets set;
	Edge tree[],ed[];
	int numOfVert;
	int sizeTree,sumTree;
	public Kruskal(Edge ed[]) {
		this.ed = ed;
		numOfVert();
		Arrays.sort(ed);
		tree = new Edge[numOfVert-1];
		set = new DisjointSets(numOfVert);
		for (int i = 0; i < numOfVert; i++) {
			set.makeSet(i);
		}
		makeMST();
	}
	private void makeMST() {
		sumTree = sizeTree = 0;
		for (int i = 0; i < ed.length; i++) {
			if(set.union(ed[i].v1, ed[i].v2)){
				tree[sizeTree++] = ed[i];
				sumTree+= ed[i].weight;
			}
		}
		
	}
	private void numOfVert() {
		numOfVert=0;
		for (int i = 0; i < ed.length; i++) {
			if(ed[i].v1 > numOfVert) numOfVert = ed[i].v1;
			if(ed[i].v2 > numOfVert) numOfVert = ed[i].v2;
		}
		numOfVert++;
	}
	public static void main(String[] args) {
		Edge e1 = new Edge(0, 1, 19);
		Edge e2 = new Edge(0, 2, 6);
		Edge e3 = new Edge(0, 6, 25);
		Edge e4 = new Edge(1, 4, 9);
		Edge e5 = new Edge(2, 5, 17);
		Edge e6 = new Edge(2, 6, 11);
		Edge e7 = new Edge(3, 4, 14);
		Edge e8 = new Edge(3, 6, 2);
		Edge e9 = new Edge(3, 7, 21);
		Edge e10 = new Edge(5, 6, 8);
		Edge edges [] = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10};
		Kruskal k = new Kruskal(edges);
		System.out.println(Arrays.toString(k.tree));
		System.out.println(k.sumTree);
	}
}
