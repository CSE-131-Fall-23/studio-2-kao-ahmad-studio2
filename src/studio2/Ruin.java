package studio2;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you have to start?");
		double startAmount = in.nextDouble();
		System.out.println("What is the win probability?");
		double winChance = in.nextDouble();
		System.out.println("How much money will warrant you leaving?");
		double winLimit = in.nextDouble();
		System.out.println("How many days do you play?");
		int totalSimulations = in.nextInt();
		//double money = startAmount;
		int j = 1;
		//int wins = 0;
		double losses = 0;
		for(j = 1; j<=totalSimulations; j++) {
			double money = startAmount;
			int totalplays = 0;
			while((money > 0) && (money < winLimit)) {
				double numberRoll = Math.random();
				if(numberRoll <= winChance) {
					money = money +1;
				}
				else {
					money = money - 1;
				}
				totalplays = totalplays +1;
				//System.out.println(money);
				//System.out.println(numberRoll);
				}
		System.out.print("Result of day: " + j);
		if (money == 0) {
			System.out.println(" You lost");
			losses = losses -1;
		}
		else {
			System.out.println(" You won");
			wins = wins + 1;
		}
		System.out.println("Number of plays that took place: " + totalplays);
		}
		System.out.println("Actual ruin rate= " + (losses/totalSimulations)*100.0);
		double expectedRuin;
		if(winChance == 0.5) {
		expectedRuin = 1 - (startAmount/winLimit);
		}
		else {
			double a = (1 - winChance)/winChance;
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1 - Math.pow(a, winLimit));
		}
	System.out.println("expected Ruin Rate = " + expectedRuin);
	}

}
