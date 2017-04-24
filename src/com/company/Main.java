package com.company;

import javax.xml.transform.Result;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);
        String cmd = null;

        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));

        PointOfSale p1=new PointOfSale(testDatabase);


        while(true) {

            System.out.println("Waiting for input");
            cmd=sc.nextLine();
            if(cmd.equals("quit"))
                return;
            p1.Input(cmd);

        }

    }
}
