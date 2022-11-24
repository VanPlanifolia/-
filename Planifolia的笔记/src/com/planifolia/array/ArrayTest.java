package com.planifolia.array;

import com.planifolia.temp.Ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/9 14:26
 */
public class ArrayTest {
    public static void main(String[] args) {
        //定容定型的数组写法
        Ball[] balls=new Ball[3];
        int a=0;
        //有初始值的数组写法
        String[] strings=new String[]{"1","2","3"};

        //字面量的数组写法
        int[] ints={1,2,3,4,5};

        String[] intsp=new String[10];

        //使用for循环往数组里面存数据
        for (int i = 0; i <intsp.length ; i++) {
            intsp[i]= UUID.randomUUID().toString();
        }

        for (String j : intsp) {
            System.out.println(j);
        }

    }
}
