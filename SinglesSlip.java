package betCalc;

public class SinglesSlip extends SpecialSlip {
	public SinglesSlip(){
		stake = 0;
		type = 0;
		numCombs = 0;
	}
	
	public SinglesSlip(double stk, int numBets, double[] betArray){
		stake = stk;
		type = numBets;
		for(int i = 1; i <= numBets; i++){
			numCombs += combs(numBets, i);
		}
		bet = betArray;
		double[][] betCombs = new double[numCombs][];
		
		//Populate 2d Array
		int y = 0;
		
		for(int h = 0; h < bet.length; h++){
			betCombs[h] = new double[1];
			betCombs[h][0] = bet[h];
			y++;
		}
		
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
	
	//Data
	private double stake;
	private int type;
	private int numCombs;
	private double[] bet;
	private double[][] allBetCombos;
}
