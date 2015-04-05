package betCalc;

import java.util.ArrayList;

public class SinglesSlip extends SpecialSlip {
	
	public SinglesSlip(double stk, int numBets, ArrayList<Double> betArray){
		stake = stk;
		type = numBets;
		for(int i = 1; i <= numBets; i++){
			numCombs += betCalcMath.combs(numBets, i);
		}
		bets = betArray;
		
		//Populate 2d Array
		allBetCombos = betCalcMath.powerSet(betArray);
	}
	
}
