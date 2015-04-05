package betCalc;

import java.util.*;


public class SpecialSlip {
	//Data
		protected double stake;
		protected int type;
		protected int numCombs;
		protected List<Double> bets;
		protected ArrayList<List<Double>> allBetCombos;
	
	//constructors
	public SpecialSlip(){
		stake = 0;
		type = 0;
		numCombs = 0;
	}
	
	public SpecialSlip(double stk, int numBets, ArrayList<Double> betArray){
		stake = stk;
		type = numBets;
		for(int i = 2; i <= numBets; i++){
			numCombs += betCalcMath.combs(numBets, i);
		}
		
		bets = betArray;
		allBetCombos = betCalcMath.powerSet(betArray);
	}
	
	public double showOneReturn(List<Double> outcome){
		double totalOdds = 1.0;
		for(int i = 0; i < outcome.size(); i++){
			totalOdds *= outcome.get(i);
		}
		return totalOdds*this.stake;
	}
	
	public double showAllReturns(List<Double> outcome){
		double winnings = 0;
		for(int i = 0; i < this.allBetCombos.size(); i++){
			if(this.allBetCombos.get(i).containsAll(outcome) == true){
				winnings += showOneReturn(this.allBetCombos.get(i));
			}
		}
		return winnings;
	}
	
	public double totalOutlay(){
		return this.stake*this.allBetCombos.size();
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
		for(int i = 0; i < this.allBetCombos.size(); i++){
			if(totalOutlay() < showAllReturns(this.allBetCombos.get(i))){
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
			System.out.println("Bet #" + i + ": " + bets.get(i));
		}
		printAllCombos();
	}
	
	private void printAllCombos() {
		for(int i = 0; i < this.numCombs; i++){
			System.out.println("Bet Combo #" + (i+1));
			for(int j = 0; j < this.allBetCombos.get(i).size(); j++){
				System.out.println("\t" + this.allBetCombos.get(i).get(j));
			}
		}
	}
	
	private void printCombo(int index){
		System.out.println("Bet Combo #" + (index+1));
		for(int j = 0; j < this.allBetCombos.get(index).size(); j++){
			System.out.println("\t" + this.allBetCombos.get(index).get(j));
		}
		System.out.println("\t Profit: $" + showProfit(index));
	}
	
	public double showProfit(int index){
		double profit = showAllReturns(this.allBetCombos.get(index)) - totalOutlay();
		profit = Math.round(profit*100);
		profit /= 100;
		return profit;
	}

	
}
