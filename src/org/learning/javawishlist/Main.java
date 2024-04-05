package org.learning.javawishlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Gift> wishList = new ArrayList<>();

        boolean exit = false;
        while(!exit) {
            System.out.print("Do you want to add a gift? y/n ");
            String choice = scan.nextLine();

            if (choice.equalsIgnoreCase("y")){
                System.out.print("Gift name: ");
                String giftName = scan.nextLine();

                Gift gift = new Gift(giftName);
                wishList.add(gift);
            } else if (choice.equalsIgnoreCase("n")) {
                exit = true;
            } else {
                System.out.println("Invalid choice");
            }
        }

        if(!wishList.isEmpty()) {
            Collections.sort(wishList);
            System.out.println(wishList);
        }

        scan.close();
    }
}
