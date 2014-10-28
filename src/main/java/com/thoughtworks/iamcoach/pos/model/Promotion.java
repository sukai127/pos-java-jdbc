package com.thoughtworks.iamcoach.pos.model;

public abstract class Promotion {

    private int id;
    private int type;
    private String content;

    public Promotion(int id, int type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Promotion(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract double getMoney(CartItem cartItem);

}
