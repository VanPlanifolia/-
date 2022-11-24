package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 21:27
 */
public class Test {
    public static void main(String[] args) {
        CalculateUtil.calCulate(new Cone(2,3,"圆锥"));
        CalculateUtil.calCulate(new Cube(2,3,4,"立方体"));

    }
}
/**
 * 设计一个程序，要求可以计算出几何体的表面积与体积(立方体 圆锥 球)，每个几何体应该有自己的属性(边长，半径，高)等等
 * 但是他们都有公共的两个方法 求体积与求面积。并且使用者不关心底层到底有几个类，使用者只通过工具类CalculateUtil去调用，
 * 并且要求工具类 CalculateUtil 中的方法是静态的而且要实现多态，无论我往里传什么样的参数都会正确的得出结果！
 *
 * 提示：
 *   1.总共有一个接口，三个实现类，一个计算工具类一个测试类
 *   2.多态关系发生在接口与三个实现类之间
 *   3.三个实现类(立方体)的成员变量要求在构造方法中完成初始化
 */
