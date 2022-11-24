package com.planifolia.shop;

/**
 * Created by Intellij IDEA
 * 抽象类里面包含一些
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 9:38
 */
public abstract class Goods {
    private String goodsName;
    private double goodsPrice;

    public Goods(String goodsName, double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public Goods() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public abstract void sell();
}

