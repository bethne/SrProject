package com.example.bethn.gfree_srproj;

/**
 * Created by bethn on 3/30/2018.
 */

public class Item {
    private String item;
    private String itemDescription;
    private double itemPrice;
    private MenuSection menuSection;
    private boolean gfMenu;

    public Item() {
    }

    public Item(String item, String itemDescription, double itemPrice, MenuSection menuSection, boolean gfMenu) {
        this.item = item;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.menuSection = menuSection;
        this.gfMenu = gfMenu;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean getGfMenu() {
        return gfMenu;
    }

    public void setGfMenu(boolean gfMenu) {
        this.gfMenu = gfMenu;
    }
}
