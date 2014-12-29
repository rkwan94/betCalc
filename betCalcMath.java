package betCalc;

public class betCalcMath {
	public static int combs(int n, int r) {
		int nFact = fact(n);
		int rFact = fact(r);
		
		int result = nFact/(rFact*fact(n-r));
		return result;
	}

	public static int fact(int n) {
		if(n == 0){
			return 1;
		}else{
			return n*fact(n-1);
		}
	}
	
	public static boolean isSubset(double[] small, double[] big) {
		boolean possibleSubset = true;
		for(int i = 0; i < small.length; i++){
			if(countItems(small[i], big) < countItems(small[i], small)){
				possibleSubset = false;
				break;
			}
		}
		return possibleSubset;
	}
	
	public static int countItems(double item, double[] list){
		int count = 0;
		for(int i = 0; i < list.length; i++)
			if(list[i] == item){
				count++;
			}
		return count;
	}
}
