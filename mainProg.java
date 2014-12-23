package betCalc;

import java.util.Scanner;

public class mainProg {
	public static void main(String arg[]){
		//Get user input
		System.out.print("Stake: ");
		Scanner inputStake = new Scanner(System.in);
		double stake = inputStake.nextDouble();
		
		System.out.print("Number of bets: ");
		Scanner inputNumBets = new Scanner(System.in);
		int numBets = inputNumBets.nextInt();
		
		System.out.println("All odds");
		Scanner inputOdds;
		double[] betsArray = new double[numBets];
		for(int i = 0; i < numBets; i++){
			inputOdds = new Scanner(System.in);
			betsArray[i] = inputOdds.nextDouble();
		}
		
		inputStake.close();
		inputNumBets.close();
		
		SpecialSlip masterSlip = new SpecialSlip(stake, numBets, betsArray);
		masterSlip.printSlip();
		masterSlip.printWinningOutcomes();
	}
}
