package com.planifolia.shop;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 9:59
 */
public class Computer extends Goods implements Play{

    public Computer(String goodsName, double goodsPrice) {
        super(goodsName, goodsPrice);
    }

    @Override
    public void sell() {
        System.out.println(this.getGoodsName()+"作为一个商品可以售卖,单价为"+this.getGoodsPrice());
    }

    @Override
    public void play() {
        System.out.println(this.getGoodsName() + "可以打游戏");
    }
}
