package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:00
 * @Description:
 */
public abstract class Shape
{
    private double[] side;

    public double[] getSide()
    {
        return side;
    }

    public void setSide(double[] side)
    {
        this.side = side;
    }

    public abstract double area();
}
