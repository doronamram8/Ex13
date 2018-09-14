package com.example.madaim.ex13;


public class Item {
    long id;
    int num;
    int color;

    public Item(){};

    public Item(int num, int color) {
        this.num = num;
        this.color = color;

    }

    public Item(int num, int color,long id) {
        this.num = num;
        this.color = color;
        this.id=id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
