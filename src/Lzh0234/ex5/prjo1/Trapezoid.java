package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:05
 * @Description:
 */
public class Trapezoid extends Shape
{

    //up，down，height分别为梯形的上底，下底，高
    public Trapezoid(double up,double down ,double height) throws Exception
    {
        super();
        if (up<0||down<0||height<0)
        {
            throw new Exception("边长不能小于0");
        }
        else setSide(new double[]{up,down,height});

    }

    @Override
    public double area()
    {
        return ((getSide()[0]+getSide()[1])*getSide()[3])/2.0;
    }
}
