package com.planifolia.temp;

/**
 * Created by Intellij IDEA
 *
 * @author Planifolia.Van
 * @version 1.0
 * @date 2022/8/8 20:57
 */
public interface Geometry {
    /**
     * 几何体的面积
     * @return 面积
     */
    double area();

    /**
     * 几何体的体积
     * @return 面积
     */
    double volume();

    /**
     * 立方体的name
     * @return name
     */
    String getName();

}
