package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 21:01
 */
public class Cube implements Geometry{
    /**
     * 三边属性
     */

    private double sideA;
    private double sideB;
    private double sideC;
    private String name;

    public Cube(double sideA, double sideB, double sideC, String name) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.name=name;
    }


    @Override
    public double area() {
        return (sideA*sideB+sideA*sideC+sideB*sideC)*2;
    }

    @Override
    public double volume() {
        return sideA*sideB*sideC;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
