package com.company;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Kamil-PC on 23.04.2017.
 */
public class PointOfSaleTest {


    @Test
    public void setDatabaseTest() throws Exception {
        PointOfSale pointOfSale=new PointOfSale();
        pointOfSale.setDatabase(new LinkedList<>());
        assertNotNull(pointOfSale.getDatabase());

    }

    @Test
    public void setNullDatabaseTest() throws Exception {
        PointOfSale pointOfSale=new PointOfSale();
        pointOfSale.setDatabase(null);
        assertNull(pointOfSale.getDatabase());

    }

    @Test
    public void inputTest() throws Exception {
        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));
        PointOfSale pointOfSale=new PointOfSale(testDatabase);
        pointOfSale.Input("1");
        assertEquals("1",pointOfSale.getBuffer());
        assertEquals("1",pointOfSale.getTemporaryList().getLast().getBarcode());


    }

    @Test
    public void inputWrongBarcodeTest() throws Exception {
        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));
        PointOfSale pointOfSale=new PointOfSale(testDatabase);
        pointOfSale.Input("5");
        pointOfSale.Input("86786");
        assertEquals("86786",pointOfSale.getBuffer());
        assertNotEquals("86786",pointOfSale.getTemporaryList().getLast().getBarcode());
    }

    @Test
    public void inputEmptyListTest() throws Exception {
        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));
        PointOfSale pointOfSale=new PointOfSale(testDatabase);
        pointOfSale.Input("86786");
        assertEquals("86786",pointOfSale.getBuffer());
        assertTrue(pointOfSale.getTemporaryList().isEmpty());
    }


    @Test
    public void listSizeTest() throws Exception {
        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));
        PointOfSale pointOfSale=new PointOfSale(testDatabase);
        assertEquals(0,pointOfSale.getTemporaryList().size());
        pointOfSale.Input("");
        assertEquals(0,pointOfSale.getTemporaryList().size());
        pointOfSale.Input(null);
        assertEquals(0,pointOfSale.getTemporaryList().size());
        pointOfSale.Input("3");
        pointOfSale.Input("2");
        pointOfSale.Input("1");
        assertEquals(3,pointOfSale.getTemporaryList().size());
        pointOfSale.Input("exit");
        assertEquals(0,pointOfSale.getTemporaryList().size());

    }

    @Test
    public void totalSumTest() throws Exception {
        LinkedList<Item> testDatabase=new LinkedList<>();
        testDatabase.add(new Item("1","Potato",3.5f));
        testDatabase.add(new Item("2","Tomato",2.2f));
        testDatabase.add(new Item("3","Milk",5.45f));
        testDatabase.add(new Item("4","Tea",6.0f));
        testDatabase.add(new Item("5","Coffee",1.5f));
        testDatabase.add(new Item("6","Beer",9.0f));
        testDatabase.add(new Item("7","Meat",11.40f));
        PointOfSale pointOfSale=new PointOfSale(testDatabase);
        pointOfSale.Input("1");
        pointOfSale.Input("1");
        pointOfSale.Input("1");
        pointOfSale.Input("1");
        assertEquals(4*3.5f,pointOfSale.getTotalSum(),0);
        pointOfSale.Input("exit");
        assertEquals(0,pointOfSale.getTotalSum(),pointOfSale.getTotalSum());
    }



}