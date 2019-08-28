package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		int numberOfItems = scan.nextInt();
		String[] items = new String[numberOfItems];
		double[] prices = new double[numberOfItems];

		for (int i=0; i<numberOfItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}

		int numberOfCustomers = scan.nextInt();

		String[] nameOfCustomers = new String[numberOfCustomers*2];
		double[] expenseList = new double[numberOfCustomers];
		double biggestExpense = Integer.MIN_VALUE;
		double smallestExpense = Integer.MAX_VALUE;


		for (int i=0; i<numberOfCustomers; i++) {
			nameOfCustomers[i*2] = scan.next();
			nameOfCustomers[i*2+1] = scan.next();
			int numberOfItemsWhichCustomersBuy = scan.nextInt();
			double expense = 0;

			for (int j=0; j<numberOfItemsWhichCustomersBuy; j++) {
				int quantityOfItem = scan.nextInt();
				String nameOfItem = scan.next();

				int count = 0;

				while (true) {
					if (items[count].equals(nameOfItem)) {
						break;
					} else {
						count +=1;
					}
				}

				expense += prices[count] * quantityOfItem;

			}

			expenseList[i] = expense;

		}

		scan.close();

		double sum = 0;
		int maxIndex = 0;
		int minIndex = 0;
		for (int i=0; i<expenseList.length; i++) {
			sum += expenseList[i];

			if (expenseList[i] > biggestExpense) {
				biggestExpense = expenseList[i];
				maxIndex = i;
			}

			if (expenseList[i] < smallestExpense) {
				smallestExpense = expenseList[i];
				minIndex = i;
			}
		}
		double averageExpense = sum / numberOfCustomers;

		System.out.println("Biggest: " + nameOfCustomers[maxIndex*2] + " "
				+ nameOfCustomers[maxIndex*2+1] + " (" + String.format("%.2f", biggestExpense) + ")");

		System.out.println("Smallest: " + nameOfCustomers[minIndex*2] + " "
				+ nameOfCustomers[minIndex*2+1] + " (" + String.format("%.2f", smallestExpense) + ")");

		System.out.println("Average: " + String.format("%.2f", averageExpense));









	}
}
