package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 21:15
 */
public class Cone implements Geometry{
    /**
     * 半径和高
     */
    private double r;
    private double height;
    private String name;

    public Cone(double r,double height,String name){
        this.r=r;
        this.height=height;
        this.name=name;
    }

    @Override
    public double area() {
        return Math.PI*r*(r+height);
    }

    @Override
    public double volume() {
        return (1/3.0)*Math.PI*r*r;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
