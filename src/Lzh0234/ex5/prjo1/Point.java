package Lzh0234.ex5.prjo1;

import java.util.ArrayList;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:06
 * @Description:
 */
public class Point
{
    private String name;
    private double x;
    private double y;

    Point(String name,double x,double y)
    {
        this.name=name;
        this.x=x;
        this.y=y;
    }

    public String getName()
    {
        return name;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }



}
