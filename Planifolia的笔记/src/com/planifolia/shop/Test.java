package com.planifolia.shop;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 10:03
 */
public class Test {
    public static void main(String[] args) {
        Shop.sell(new Computer("电脑",19999.0));
        Shop.play(new Computer("电脑",19999.0));
    }
}
/**
 * 练习：当前有两个商品手机和电脑，这两个商品都有公共的属性name，price(售价)一个公共方法sell(售卖)，
 * 但是区别是 手机只能打电话，电脑只能玩游戏。所以再 商店(类)里面的两个 行为(方法)只能传对应的类型，
 * 比如play方法只能传电脑类，call方法只能传手机类。
 *
 */