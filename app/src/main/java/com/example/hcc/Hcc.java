package com.example.hcc;

/**
 * Created by vera on 2018/4/9.
 */

public class Hcc
{
    private String name;
    private int imageId;
    public Hcc(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public  String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
