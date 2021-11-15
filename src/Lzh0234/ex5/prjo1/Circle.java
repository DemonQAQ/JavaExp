package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:04
 * @Description:
 */
public class Circle extends Shape
{
    //r为半径
    Circle(double r) throws Exception
    {
        super();
        if (r < 0)
        {
            throw new Exception("半径不能小于0");
        } else setSide(new double[]{r});
    }

    @Override
    public double area()
    {
        return 2.0 * Math.PI * Math.pow(getSide()[0], 2);
    }
}
