package com.example.bethn.gfree_srproj;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bethn on 3/30/2018.
 */

public class Item implements Parcelable {
    private String item;
    private String itemDescription;
    private double itemPrice;
//    private MenuSection menuSection;
    private boolean gfMenu;

    public Item() {
    }

    public Item(String item, String itemDescription, double itemPrice, MenuSection menuSection, boolean gfMenu) {
        this.item = item;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
//        this.menuSection = menuSection;
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

    protected Item(Parcel in) {
        item = in.readString();
        itemDescription = in.readString();
        itemPrice = in.readDouble();
//        menuSection = (MenuSection) in.readValue(MenuSection.class.getClassLoader());
        gfMenu = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item);
        dest.writeString(itemDescription);
        dest.writeDouble(itemPrice);
//        dest.writeValue(menuSection);
        dest.writeByte((byte) (gfMenu ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
