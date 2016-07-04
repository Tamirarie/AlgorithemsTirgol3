package Best;

import java.util.Arrays;

public class BestMatrix {
	
	public static int[] getBest(int mat[][]){
		int max = Integer.MIN_VALUE;
		int n = mat.length;
		int m = mat[0].length;
		int iStart=-1,iEnd=-1,jStart=-1,jEnd=-1;
		int help [][] = new int[n][m+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				help[i][j+1] = help[i][j] + mat[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				int temp[] = new int[n];
				for (int k = 0; k < n; k++) {
					temp[k] = help[k][j+1] - help[k][i];
				}
				Best b = new Best(temp);
				if(b.max>max){
					max = b.max;
					iStart = b.start;
					iEnd = b.end;
					jStart = i;
					jEnd = j;
				}
				else if(b.max == max){
					if(b.len > (jEnd-jStart+1)*(iEnd-iStart+1)){
						b.len = (jEnd-jStart+1)*(iEnd-iStart+1);
						iStart = b.start;
						iEnd = b.end;
						jStart = i;
						jEnd = j;
					}
				}
			}
		}
		
		
		return new int[]{max,iStart,jStart,iEnd,jEnd};
	}
	
	
	public static void main(String[] args) {
		int mat[][] = {{1,-40}
		,{2,-30}
		,{3,-40},
		{-50,6}};
		System.out.println(Arrays.toString(getBest(mat)));
	}
}
