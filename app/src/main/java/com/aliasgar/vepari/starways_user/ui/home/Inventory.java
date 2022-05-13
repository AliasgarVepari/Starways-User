package com.aliasgar.vepari.starways_user.ui.home;

public class Inventory {
    private String Itemprice;
    private String ItemName;
    private int ItemImg;

    public Inventory(String itemName ,int itemImg, String itemprice) {
        Itemprice = itemprice;
        ItemName = itemName;
        ItemImg = itemImg;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getItemImg() {
        return ItemImg;
    }
}
