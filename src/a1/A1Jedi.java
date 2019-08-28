package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

        int numberOfItems = scan.nextInt();

        // set the item array
        Item[] items = new Item[numberOfItems];

        // store the names of items
        for (int i=0; i < items.length; i++) {
            items[i] = new Item(scan.next());
            scan.next(); // discard the fruit price
        }

        int numberOfCustomers = scan.nextInt();


        for (int i=0; i < numberOfCustomers; i++) {

            // discard the first name and the last name of one customer
            scan.next();
            scan.next();


            int numberOfItems_In_ShoppingList = scan.nextInt();

            // set the shopping list array
            ShoppingList[] shoppingLists = new ShoppingList[numberOfItems_In_ShoppingList];

            // set the index array in order to count how many different customers bought the same item
            int[] index = new int[numberOfItems_In_ShoppingList];


            // store the item name and item quantity into shopping list array
            for (int j=0; j < numberOfItems_In_ShoppingList; j++) {
                shoppingLists[j] = new ShoppingList();

                shoppingLists[j].setQuantity(scan.nextInt());
                shoppingLists[j].setName(scan.next());

                // find out the index of the item and store it

                for (int k=0; k < items.length; k++) {
                    if (items[k].getItemName().equals(shoppingLists[j].getName())) {
                        index[j] = k;
                    }
                }

                // calculate the total quantity of items
                items[index[j]].raiseCountTotalQuantity(shoppingLists[j].getQuantity());

            }

            // the first item in the shopping list is not likely to repeat, so just do the raising
            items[index[0]].raiseCountCustomers();

            // 1. eliminate the possibly repetitive index number
            // 2. raise the count of customers for the following items in the shopping list

            for (int j=1; j < numberOfItems_In_ShoppingList; j++) {

                boolean check = true;

                for (int k=j; k > 0; k--) {
                    if (index[k-1] == index[j]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    items[index[j]].raiseCountCustomers();
                }

            }

        }

        scan.close();

        for (Item each : items) {
            if (each.getCountCustomers() == 0) {
                System.out.println("No customers bought " + each.getItemName());
            } else {
                System.out.println(each.getCountCustomers() + " Customers bought " +
                        each.getCountTotalQuantity() + " " + each.getItemName());
            }
        }

	}
}

class Item {

    private String name;
    private int countCustomers = 0;
    private int countTotalQuantity = 0;

    // constructor
    Item(String name) {
        this.name = name;
    }

    String getItemName() {
        return this.name;
    }

    void raiseCountCustomers() {
        this.countCustomers ++;
    }

    void raiseCountTotalQuantity(int increment) {
        this.countTotalQuantity += increment;
    }

    int getCountCustomers() {
        return this.countCustomers;
    }

    int getCountTotalQuantity() {
        return this.countTotalQuantity;
    }


}

class ShoppingList {
    private String name;
    private int quantity;

    // constructor
    ShoppingList() {

    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int getQuantity() {
        return this.quantity;
    }

}
