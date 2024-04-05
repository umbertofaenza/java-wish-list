package org.learning.javawishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File wishlistFile = new File("./resources/wishlist.txt");
        List<Gift> wishList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        try(Scanner fileReader = new Scanner(wishlistFile)) {
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Gift gift = new Gift(line);

                wishList.add(gift);
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        boolean exit = false;
        while(!exit) {
            System.out.print("Do you want to add a gift? y/n ");
            String choice = scan.nextLine();

            if (choice.equalsIgnoreCase("y")){
                System.out.print("Gift name: ");

                try{
                String giftName = scan.nextLine();
                    Gift gift = new Gift(giftName);
                    wishList.add(gift);
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice.equalsIgnoreCase("n")) {
                exit = true;
            } else {
                System.out.println("Invalid choice");
            }
        }

        if(!wishList.isEmpty()) {
            //Collections.sort(wishList);

            try(FileWriter fileWriter = new FileWriter(wishlistFile)) {
                for(Gift gift : wishList) {
                    fileWriter.write(gift.getName() + "\n");
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(wishList);
        }

        scan.close();
    }
}
