package betCalc;

import java.util.ArrayList;
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
		ArrayList<Double> betsArray = new ArrayList<Double>();
		for(int i = 0; i < numBets; i++){
			inputOdds = new Scanner(System.in);
			betsArray.add(inputOdds.nextDouble());
		}
		
		inputStake.close();
		inputNumBets.close();
		
		SpecialSlip masterSlip = new SpecialSlip(stake, numBets, betsArray);
		masterSlip.printSlip();
		masterSlip.printWinningOutcomes();
		
		SinglesSlip newSlip = new SinglesSlip(stake, numBets, betsArray);
		newSlip.printSlip();
		newSlip.printWinningOutcomes();
	}
}
