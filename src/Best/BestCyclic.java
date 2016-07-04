package Best;

import java.util.Arrays;

public class BestCyclic {
	
	public static int[] getBest(int arr[]){
		Best best = new Best(arr);
		int neg[] = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < neg.length; i++) {
			neg[i] = arr[i]*-1;
			sum+=arr[i];
		}
		Best negBest = new Best(neg);
		if(best.max<0 || best.max > sum + negBest.max) return best.getBest();
		return new int[]{sum+negBest.max,negBest.end,negBest.start-1};
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,-9,3};
		System.out.println(Arrays.toString(getBest(arr)));
	}
}
