package a1;

import java.util.Scanner;

public class A1Novice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Your code follows here.


        // get the number of customers
        int numberOfCustomers = scan.nextInt();

        // store the information that need to output for every customer
        String[] output = new String[numberOfCustomers];

        // 1. compute the total cost of every customer
        // 2. organize the information in format required
        for (int i = 0; i < numberOfCustomers; i++) {

            // get the name and number of items of one customer
            String firstName = scan.next();
            String lastName = scan.next();
            int numberOfItems = scan.nextInt();


            // compute the total cost of one customer
            double totalCost = 0;

            for (int j = 0; j < numberOfItems; j++) {
                int quantityOfItem = scan.nextInt();
                String nameOfItem = scan.next();
                double priceOfItem = scan.nextDouble();
                totalCost += quantityOfItem * priceOfItem;
            }

            // organize the output information and store it into the output array created above
            String outputFormatOfFirstName = firstName.substring(0, 1);
            output[i] = outputFormatOfFirstName + ". " +
                    lastName + ": " +
                    String.format("%.2f", totalCost);
        }

        scan.close();

        // output the information in lines
        for (String element : output) {
            System.out.println(element);
        }


    }
//	public static String customerInput (String firstName, String lastName, int numberOfItems, Scanner scan) {
//
////		Scanner scan = new Scanner(System.in);
//
//		double totalCost = 0;
//
//		for (int i=0; i<numberOfItems; i++) {
//			int quantityOfItem = scan.nextInt();
//			String nameOfItem = scan.next();
//			double priceOfItem = scan.nextDouble();
//			totalCost += quantityOfItem * priceOfItem;
//		}
//
//		String outputFormatOfFirstName = firstName.substring(0, 1);
//
//		return outputFormatOfFirstName + ". " + lastName + ": " + String.format("%.2f", totalCost);
//	}
}
