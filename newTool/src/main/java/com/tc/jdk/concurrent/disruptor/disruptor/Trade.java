package com.tc.jdk.concurrent.disruptor.disruptor;

public class Trade {
	private String id;
    private String name;
    private double price;
    
    
    public Trade(String id) {
		super();
		this.id = id;
	}
    
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
