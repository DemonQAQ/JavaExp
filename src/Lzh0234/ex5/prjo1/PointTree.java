package Lzh0234.ex5.prjo1;

import java.util.ArrayList;

public class PointTree
{
    int length = 0;
    ArrayList<String> points;
    ArrayList<Point[]> pointsDivided;
    PointTree next;

    PointTree()
    {
        points = new ArrayList<>();
        pointsDivided = new ArrayList<>();
    }

    private PointTree(int length)
    {
        this.length=length;
        points = new ArrayList<>();
        pointsDivided = new ArrayList<>();
    }

    public void createChild()
    {
        next = new PointTree(this.length+1);
    }

    public int getLength()
    {
        return length;
    }

    public ArrayList<String> getPoints()
    {
        return points;
    }

    public void setPoints(String points)
    {
        this.points.add(points);
    }

    public ArrayList<Point[]> getPointsDivided()
    {
        return pointsDivided;
    }

    public void setPointsDivided(Point[] points)
    {
        this.pointsDivided.add(points);
    }
}
