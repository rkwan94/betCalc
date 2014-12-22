package betCalc;

import java.util.Scanner;

public class mainProg {
	public static void main(String arg[]){
		//Get user input
		Scanner inputStake = new Scanner(System.in);
		double stake = inputStake.nextDouble();
		
		Scanner inputNumBets = new Scanner(System.in);
		int numBets = inputNumBets.nextInt();
		
		Scanner inputOdds;
		double[] betsArray = new double[numBets];
		for(int i = 0; i < numBets; i++){
			inputOdds = new Scanner(System.in);
			betsArray[i] = inputOdds.nextDouble();
		}
		
		SpecialSlip masterSlip = new SpecialSlip(stake, numBets, betsArray);
		masterSlip.printSlip();
	}
}
