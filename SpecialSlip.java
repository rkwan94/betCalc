package betCalc;

public class SpecialSlip {
	//constructors
	public SpecialSlip(){
		stake = 0;
		type = 0;
		numCombs = 0;
	}
	
	public SpecialSlip(double stk, int numBets, double[] betArray){
		stake = stk;
		type = numBets;
		for(int i = 2; i <= numBets; i++){
			numCombs += combs(numBets, i);
		}
		bet = betArray;
		double[][] betCombs = new double[numCombs][];
		
		//Populate 2d Array
		int y = 0;
		for(int i = 0; i < type; i++){
			for(int j = i+1; j < type; j++){
				for(int k = j+1; k < type; k++){
					for(int l = k+1; l < type; l++){
						for(int m = l+1; m < type; m++){
							for(int n = m+1; n < type; n++){
								for(int o = n+1; o < type; o++){
									for(int p = o + 1; p < type; p++){
										betCombs[y] = new double[8];
										betCombs[y][0] = bet[i];
										betCombs[y][1] = bet[j];
										betCombs[y][2] = bet[k];
										betCombs[y][3] = bet[l];
										betCombs[y][4] = bet[m];
										betCombs[y][5] = bet[n];
										betCombs[y][6] = bet[o];
										betCombs[y][7] = bet[p];
										y++;
									}
									
									betCombs[y] = new double[7];
									betCombs[y][0] = bet[i];
									betCombs[y][1] = bet[j];
									betCombs[y][2] = bet[k];
									betCombs[y][3] = bet[l];
									betCombs[y][4] = bet[m];
									betCombs[y][5] = bet[n];
									betCombs[y][6] = bet[o];
									y++;
								}
								
								betCombs[y] = new double[6];
								betCombs[y][0] = bet[i];
								betCombs[y][1] = bet[j];
								betCombs[y][2] = bet[k];
								betCombs[y][3] = bet[l];
								betCombs[y][4] = bet[m];
								betCombs[y][5] = bet[n];
								y++;
							}
							
							betCombs[y] = new double[5];
							betCombs[y][0] = bet[i];
							betCombs[y][1] = bet[j];
							betCombs[y][2] = bet[k];
							betCombs[y][3] = bet[l];
							betCombs[y][4] = bet[m];
							y++;
						}

						betCombs[y] = new double[4];
						betCombs[y][0] = bet[i];
						betCombs[y][1] = bet[j];
						betCombs[y][2] = bet[k];
						betCombs[y][3] = bet[l];
						y++;
					}

					betCombs[y] = new double[3];
					betCombs[y][0] = bet[i];
					betCombs[y][1] = bet[j];
					betCombs[y][2] = bet[k];
					y++;
				}

				betCombs[y] = new double[2];
				betCombs[y][0] = bet[i];
				betCombs[y][1] = bet[j];
				y++;
			}
		}
		
		allBetCombos = betCombs;
	}
	
	public double showOneReturn(double[] outcome){
		double totalOdds = 1.0;
		for(int i = 0; i < outcome.length; i++){
			totalOdds *= outcome[i];
		}
		return totalOdds*stake;
	}
	
	public double showAllReturns(double[] outcome){
		double winnings = 0;
		for(int i = 0; i < outcome.length; i++){
			if(isSubset(allBetCombos[i], outcome) == true){
				winnings += showOneReturn(allBetCombos[i]);
			}
		}
		return winnings;
	}
	
	public double totalOutlay(){
		return stake*allBetCombos.length;
	}
	
	private int combs(int n, int r) {
		int nFact = fact(n);
		int rFact = fact(r);
		
		int result = nFact/(rFact*fact(n-r));
		return result;
	}

	private int fact(int n) {
		if(n == 0){
			return 1;
		}else{
			return n*fact(n-1);
		}
	}
	
	private boolean isSubset(double[] small, double[] big) {
		boolean possibleSubset = true;
		for(int i = 0; i < small.length; i++){
			if(countItems(small[i], big) < countItems(small[i], small)){
				possibleSubset = false;
				break;
			}
		}
		return possibleSubset;
	}
	
	private int countItems(double item, double[] list){
		int count = 0;
		for(int i = 0; i < list.length; i++)
			if(list[i] == item){
				count++;
			}
		return count;
	}
	
	public double[] getLeastWins(double[][] allOutcomes){
		double[] leastWins = allOutcomes[0];
		for(int i = 0; i < allOutcomes.length; i++){
			
		}
		return leastWins;
	}
	
	public void printWinningOutcomes(){
		System.out.println("These outcomes will produce profitable wins:");
		System.out.println("Total cost: $" + totalOutlay());
		for(int i = 0; i < allBetCombos.length; i++){
			if(totalOutlay() < showAllReturns(allBetCombos[i])){
				printCombo(i);
			}
		}
	}

	public void printSlip(){
		System.out.println("This is the information on your bet slip");
		System.out.println("Stake Amount: $" + stake);
		System.out.println("Number of bets: " + type);
		System.out.println("All bets");
		for(int i = 0; i < type; i++){
			System.out.println("Bet #" + i + ": " + bet[i]);
		}
		printAllCombos();
	}
	
	private void printAllCombos() {
		for(int i = 0; i < numCombs; i++){
			System.out.println("Bet Combo #" + (i+1));
			for(int j = 0; j < allBetCombos[i].length; j++){
				System.out.println("\t" + allBetCombos[i][j]);
			}
		}
	}
	
	private void printCombo(int index){
		System.out.println("Bet Combo #" + (index+1));
		for(int j = 0; j < allBetCombos[index].length; j++){
			System.out.println("\t" + allBetCombos[index][j]);
		}
	}
	

	//Data
	private double stake;
	private int type;
	private int numCombs;
	private double[] bet;
	private double[][] allBetCombos;
}
