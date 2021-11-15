package Lzh0234.ex5.prjo1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/14 16:45
 * @Description:
 */
public class Polygon
{
    private ArrayList<Point> points;
    private ArrayList<String> sequence;
    private ArrayList<Point[]> pointSet;


    public ArrayList<Point> getPoints()
    {
        return points;
    }

    public void setPoints(ArrayList<Point> points)
    {
        this.points = points;
    }

    public ArrayList<String> getSequence()
    {
        return sequence;
    }

    public void setSequence(ArrayList<String> sequence)
    {
        this.sequence = sequence;
    }



    //需要有序的点集
    public double Shoelace(Point @NotNull [] points)
    {
        double s = 0;
        int j;
        for (int i = 0; i < points.length; i++)
        {
            j = (i + 1) % points.length;
            s += (points[i].getX() * points[j].getY()) - (points[j].getX() * points[i].getY());
        }
        return s > 0 ? s / 2.0 : (-s) / 2.0;
    }
}
