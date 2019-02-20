package designPatterns.structualDesignPatterns.flyWeightPattern;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Created by jialei.zou on 2018/11/13 .
 */
public class Line implements Shape {

    public Line(){
        System.out.println("Creating Line object");
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics line, int x1, int y1, int x2, int y2,
                     Color color) {
        line.setColor(color);
        line.drawLine(x1, y1, x2, y2);
    }

}