package com.planifolia.shop;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 10:01
 */
public class Shop {
    public static void sell(Goods goods){
        goods.sell();
    }
    public static void call(Call call){
        call.call();
    }
    public static void play(Play play){
        play.play();
    }
}
