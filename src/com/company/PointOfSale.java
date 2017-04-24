package com.company;

import java.util.LinkedList;

/**
 * Created by Kamil-PC on 21.04.2017.
 */
public class PointOfSale {

    private String m_buffer;
    private LinkedList<Item> m_temporaryList;
    private float m_totalSum;
    private LinkedList<Item> m_database;

    public PointOfSale(){
        m_buffer=null;
        m_temporaryList=new LinkedList<Item>();
        m_totalSum=0;
        m_database=null;
    }


    public PointOfSale(LinkedList<Item> database){
        m_buffer=null;
        m_temporaryList=new LinkedList<Item>();
        m_totalSum=0;
        m_database=database;
    }

    public void Input(String arg){
        m_buffer=arg;

        try {
            if (m_buffer.equals("") || m_buffer.equals(null)) {
                PrintOnLCD("Invalid bar code");
            } else if (m_buffer.equals("exit")) {
                for (Item item : m_temporaryList) {
                    PrintReceipt(item.getItemName() + " " + item.getItemPrice());
                }
                PrintReceipt("Total sum: " + m_totalSum);
                PrintOnLCD("Total sum: " + m_totalSum);
                m_temporaryList.clear();
                m_totalSum = 0;
            } else {
                if (FindProduct()) {
                    PrintOnLCD(m_temporaryList.getLast().getItemName() + " " + m_temporaryList.getLast().getItemPrice());
                } else {
                    PrintOnLCD("Product not found");
                }
            }
        }catch(NullPointerException e){
            System.out.println("Database is equal to: "+e.getMessage());
        }

    }

    private void PrintOnLCD(String arg) {
        System.out.println("LCD: "+arg);
    }

    private void PrintReceipt(String arg) {
        System.out.println("Printer: "+ arg);
    }


    private boolean FindProduct(){

        for (Item item: m_database) {
            if(m_buffer.equals(item.getBarcode())){
                m_temporaryList.addLast(item);
                m_totalSum += item.getItemPrice();
                return true;
            }
        }
        return false;
    }

    public void setDatabase(LinkedList<Item> database) {
        this.m_database = database;
    }

    public LinkedList<Item> getDatabase() {
        return m_database;
    }

    public LinkedList<Item> getTemporaryList() {
        return m_temporaryList;
    }

    public String getBuffer(){
        return m_buffer;
    }

    public float getTotalSum(){
        return m_totalSum;
    }

}
