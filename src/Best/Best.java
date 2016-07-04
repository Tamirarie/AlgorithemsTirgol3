package Best;

import java.util.Arrays;

public class Best {
	int arr[];
	int max,start,end,len;
	public Best(int arr[]) {
		this.arr = arr;
		algo();
	}
	
	private void algo() {
		int tempBegin = getFirstPos();
		max = arr[tempBegin];
		start = tempBegin;
		end = tempBegin;
		int sum = max;
		len = arr.length;
		for (int i = tempBegin+1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				sum = 0;
				tempBegin = i+1;
			}
			else if(sum > max){
				max = sum;
				start = tempBegin;
				end = i;
				len = end-start+1;
			}
			else if (len > i - tempBegin+1){
				start = tempBegin;
				end = i;
				len = end-start+1;
			}
		}
	}


	private int getFirstPos(){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		return 0;
	}
	public int[] getBest(){
		return new int[]{max,start,end,len};
	}
	public static void main(String[] args) {
		int arr[] = {-3,2,1,-40,3,-1};
		Best b = new Best(arr);
		System.out.println(Arrays.toString(b.getBest()));
	}
}
