package com.planifolia.shop;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 9:55
 */
public class Phone extends Goods implements Call{
    @Override
    public void call() {
        System.out.println("手机可以打电话");
    }

    @Override
    public void sell() {
        System.out.println(this.getGoodsName()+"作为一个商品可以售卖,单价为"+this.getGoodsPrice());
    }
}
