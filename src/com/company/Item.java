package com.company;

/**
 * Created by Kamil-PC on 21.04.2017.
 */
public class Item {
    private String m_barCode;
    private String m_itemName;
    private float m_itemPrice;

    public Item(){
        m_barCode=null;
        m_itemName=null;
        m_itemPrice=0;
    }

    public Item(String barcode,String name,float price){
        m_barCode=barcode;
        m_itemName=name;
        m_itemPrice=price;
    }

    public String getBarcode(){
        return m_barCode;
    }


    public String getItemName(){
        return m_itemName;
    }

    public float getItemPrice(){
        return m_itemPrice;
    }
}
