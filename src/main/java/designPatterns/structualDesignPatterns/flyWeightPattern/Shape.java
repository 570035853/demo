package designPatterns.structualDesignPatterns.flyWeightPattern;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Created by jialei.zou on 2018/11/13 .
 */


public interface Shape {

    public void draw(Graphics g, int x, int y, int width, int height,
                     Color color);
}
