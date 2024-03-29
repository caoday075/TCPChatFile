/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author SE130531
 */
public class ItemDTO {
    private String itemCode;
    private String itemName;
    private String supCode;   
    private String unit;
    private int price = 0;
    private boolean supplying = false;
        
    public Vector toVector() {
        Vector v = new Vector();
        v.add(itemCode);
        v.add(itemName);
        v.add(supCode);       
        v.add(unit);
        v.add(price);
        v.add(supplying);
        return v;
    }

    public ItemDTO() {
    }
        
    public ItemDTO(String itemCode, String itemName, String supCode, String unit, int price, boolean supplying) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.supCode = supCode;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }      
    
}
