/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression.gui;

import java.util.Comparator;
import regression.Point;

/**
 *
 * @author Karolina
 */
public class PointXComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return (int) (o1.getX() - o2.getX());
    }
}
