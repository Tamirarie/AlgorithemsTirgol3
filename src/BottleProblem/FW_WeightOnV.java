package BottleProblem;

import java.util.Arrays;


public class FW_WeightOnV {
	
	static final int inf = 999;
	public static int [][] FW(boolean bol[][], int weight[]){
		int n = bol.length;
		int m = bol[0].length;
		int mat[][] = new int[n][m];
		for (int i = 0; i < mat.length; i++)Arrays.fill(mat[i], inf);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(bol[i][j]) mat[i][j] = weight[i]+weight[j];
				
				if(i==j) mat[i][j] = 0;
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(mat[i][j] > mat[k][j] + mat[i][k]){
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
					mat[i][j] = (mat[i][j] + weight[i]+weight[j])/2;
			}
		}
		
		return mat;
	}
	
	public static void main(String[] args) {
		boolean t = true, f = false;
		boolean mat [][] = {{t,t,t,f},
							{t,t,f,t},
							{t,f,t,t},
							{f,t,t,t}};
		int w []= {1,2,3,4};
		int fw [][]= FW(mat, w);
		for (int i = 0; i < w.length; i++) {
			System.out.println(Arrays.toString(fw[i]));
		}
	//	System.out.println(fw.getPathWeight(1, 2));
	//	System.out.println(fw.getPath(1, 2));
	}
}
