package Best;

public class gasStationsProb {
	public static boolean isPossible(int gasStations[],int gasPrices[] ){
		int n = gasStations.length;
		int dif[] = new int [n];
		for (int i = 0; i < dif.length; i++) {
			dif[i] = gasStations[i] - gasPrices[i];
		}
		int best[] = BestCyclic.getBest(dif);
		int sum = 0;
		for (int i = 0; i < best.length; i++) {
			sum+= dif[(best[1]+i)%n];
			if(sum<0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int gasStations[] = {1,4,3,7,2,4,8};
		int gasPrices[] = {3,5,2,1,4,3,9};
		System.out.println(isPossible(gasStations, gasPrices));
	}
}	
