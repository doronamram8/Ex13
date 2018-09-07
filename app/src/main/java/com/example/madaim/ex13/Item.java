package com.example.madaim.ex13;

/**
 * Created by Madaim on 07/09/2018.
 */

public class Item {
    int id;
    int num;
    int color;

    public Item( int num, int color) {
        this.num = num;
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
