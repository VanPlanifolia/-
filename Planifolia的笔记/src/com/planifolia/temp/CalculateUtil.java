package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 21:17
 */
public class CalculateUtil {

    public static void calCulate(Geometry geometry){

        System.out.println(geometry.getName()+"的体积为："+geometry.volume());
        System.out.println(geometry.getName()+"的面积为："+geometry.area());
    }
}
