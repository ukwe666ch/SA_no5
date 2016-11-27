package com.sample.store.entity;

public class Product {
    private long id;
    private int category;
    private String desc;
    private int inventory;
    private int reorderPoint;

    /* getters and setters */
    public long getId(){
            return id;
    }
    public void setId(long id){
    	this.id = id;
    }

    public int getCategory(){
            return category;
    }
    public void setCategory(int category){
        this.category = category;
    }
    
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
    	this.desc = desc;
    }

    public int getInventory(){
    		return inventory;
    }
    public void setInventory(int inventory){
		this.inventory = inventory;
    }
    
    public int getReorderPoint(){
    		return reorderPoint;
    }
    public void setReorderPoint(int reorderPoint){
		this.reorderPoint = reorderPoint;
    }

    /*
    public Object get(int attr){
    	switch(attr){
    	case 0:
    		return id;
    	case 1:
    		return category;
    	case 2:
    		return desc;
    	case 3:
    		return inventory;
    	case 4:
    		return reorderPoint;
    	default:
    		return "";
    	}
    }
*/
}//Product
