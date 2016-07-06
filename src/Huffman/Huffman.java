package Huffman;

import java.util.concurrent.ArrayBlockingQueue;

/*
 * O(n) using two Queues;
 */
public class Huffman {
	final int LEFT=1,RIGHT=2,PARENT=3,WEIGHT=0;	
	int Tree[][],freq[];
	char chars[];
	String code[];
	
	int n ;
	ArrayBlockingQueue<Integer> q1,q2;
	public Huffman(char chars[],int freq[]) {
		n = freq.length;
		this.freq = freq;
		this.chars = chars;
		Tree = new int[2*n-1][4];
		q1 = new ArrayBlockingQueue<>(n);
		q2 = new ArrayBlockingQueue<>(n);
		code = new String[n];
		for (int i = 0; i < freq.length; i++) {
			Tree[i][WEIGHT] = freq[i];
			q1.add(i);
		}
		buildTree();
		buildCode("",2*n-2);
	}
	private void buildCode(String code, int i) {
		if(i < n){
			this.code[i] = code;
			return;
		}
		buildCode(code + "0", Tree[i][LEFT]);
		buildCode(code+"1", Tree[i][RIGHT]);
	}
	private void buildTree() {
		int k = n;
		while(q1.size()+q2.size() > 1){
			int l = getMin();
			int r = getMin();
			Tree[l][PARENT] = k;
			Tree[r][PARENT] = k;
			Tree[k][WEIGHT] = Tree[l][WEIGHT] + Tree[r][WEIGHT];
			Tree[k][LEFT] = l;
			Tree[k][RIGHT] = r;
			q2.add(k);
			k++;
		}
	}
	private int getMin() {
		if(q1.isEmpty()) return q2.poll();
		if(q2.isEmpty()) return q1.poll();
		if(Tree[q1.peek()][WEIGHT]> Tree[q2.peek()][WEIGHT]) return q2.poll();
		return q1.poll();
	}
	private String getCode(){
		String ans = "";
		for (int i = 0; i < code.length; i++) {
			ans += "code:" + chars[i]+" = " + code[i] + "\n";
		}
		return ans;
	}
	public static void main(String[] args) {
		char chars[] = {'f','e','c','b','d','a'};
		int freq[] = {5,9,12,13,16,45};
		Huffman h = new Huffman(chars, freq);
		System.out.println(h.getCode());
		System.out.println();
	}
}
