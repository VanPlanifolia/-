package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 21:13
 */
public class Ball implements Geometry{
    /**
     * 半径
     */
    private double r;
    private String name;

    public Ball(double r,String name){
        this.r=r;
        this.name=name;
    }

    @Override
    public double area() {
        return 4*Math.PI*this.r*this.r;
    }

    @Override
    public double volume() {
        return (4/3.0)*Math.PI*r*r*r;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
